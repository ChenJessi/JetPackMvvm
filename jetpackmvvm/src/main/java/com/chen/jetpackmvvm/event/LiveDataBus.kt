
package com.chen.jetpackmvvm.event


import android.util.Log
import androidx.lifecycle.*
import com.chen.jetpackmvvm.ext.getClazz
import java.util.concurrent.ConcurrentHashMap

/**
 * liveDataBus
 * 事件总线
 */
object LiveDataBus {

    private val mHashMap =
        ConcurrentHashMap<String, StickyLiveData<out Any>>()

    /**
     * 事件的名称
     * 同一事件只允许有一个类型
     * 否则强转失败崩溃
     */
     fun < T : Any> with(eventName: String): StickyLiveData<T> {
        var liveData = mHashMap[eventName]
        if (liveData == null) {
            liveData = StickyLiveData<T>(eventName)
            mHashMap[eventName] = liveData
        }

        return liveData as StickyLiveData<T>
    }


    class StickyLiveData<T : Any>(private val mEventName: String) :
        LiveData<T>() {
        private  var mStickyData: T? = null
        private var mVersion = 0

        //复写LiveData的setValue，postValue方法，并自行管理version的值。
        //因为LiveData它默认黏性事件,而企业开发中,肯定不是所有场合都适用黏性事件
        //所以，我们自己管理liveData消息发送次数和观察者接收消息的次数。
        public override fun setValue(value: T) {
            mVersion++
            super.setValue(value)
        }

        public override fun postValue(value: T) {
            mVersion++
            super.postValue(value)
        }

        //同时暴露两个方法用于发射黏性事件.
        //通过setValue，postValue方法发送的数据将不会被应用于黏性数据分发
        fun setStickyData(stickyData: T) {
            mStickyData = stickyData
            setValue(stickyData)
        }

        fun postStickyData(stickyData: T) {
            mStickyData = stickyData
            postValue(stickyData)
        }

        //同时复写LiveData的observe方法。并且代理传递进来的observer对象
        override fun observe(
            owner: LifecycleOwner,
            observer: Observer<in T>
        ) {
            observerSticky(owner, observer, false)
        }

        //再暴露一个方法，用以关心黏性事件的,同时监听宿主的生命周期在onDestroy时自动执行反注册。所以使用时就不用手动反注册了
        //如此我们便能支持1.发送黏性事件  2.观察黏性事件，而不是默认能接收到黏性数据
        fun observerSticky(
            owner: LifecycleOwner,
            observer: Observer<in T>,
            sticky: Boolean
        ) {
            super.observe(owner, WrapperObserver(this, observer, sticky))
            owner.lifecycle.addObserver(LifecycleEventObserver { source, event ->
                if (event == Lifecycle.Event.ON_DESTROY) {
                    mHashMap.remove(mEventName)
                }
            })
        }

        private inner class WrapperObserver(
            var mLiveData: StickyLiveData<T>,
            var mObserver: Observer<in T>,
            var sticky: Boolean
        ) : Observer<T> {
            //标记该liveData已经发射几次数据了，用以过滤老数据重复接收
            private var mLastVersion = 0

            init {
                //比如先使用StickyLiveData发送了一条数据。StickyLiveData#version=1
                //那当我们创建WrapperObserver注册进去的时候，就至少需要把它的version和 StickyLiveData的version保持一致
                //用以过滤老数据，否则 岂不是会收到老的数据？
                mLastVersion = mLiveData?.mVersion
            }

            override fun onChanged(t: T) {
                //如果当前observer收到数据的次数已经大于等于了StickyLiveData发送数据的个数了则return

                /**
                 * observer.mLastVersion >= mLiveData.mVersion
                 * 这种情况 只会出现在，我们先行创建一个liveData发射了一条数据。此时liveData的mversion=1.
                 *
                 * 而后注册一个observer进去。由于我们代理了传递进来的observer,进而包装成wrapperObserver，此时wrapperObserver的lastVersion 就会跟liveData的mversion 对齐。保持一样。把wrapperObserver注册到liveData中。
                 *
                 * 根据liveData的原理，一旦一个新的observer 注册进去,也是会尝试把数据派发给他的。这就是黏性事件(先发送,后接收)。
                 *
                 * 但此时wrapperObserver的lastVersion 已经和 liveData的version 一样了。由此来控制黏性事件的分发与否
                 */

                if (mLastVersion >= mLiveData?.mVersion){
                    //如果当前 observer 关心 粘性事件
                    if (sticky && mLiveData?.mStickyData != null){
                        mObserver.onChanged(mLiveData?.mStickyData)
                    }
                    return
                }
                mLastVersion = mLiveData.mVersion
                mObserver.onChanged(t)
            }
        }

    }

}

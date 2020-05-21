package com.chen.jetpackmvvm.event


import androidx.lifecycle.*
import java.util.concurrent.ConcurrentHashMap

class LiveDataBus {
    private object Lazy {
        var sLiveDataBus = LiveDataBus()
    }

    private val mHashMap =
        ConcurrentHashMap<String, StickyLiveData<*>>()

    //事件的名称
    fun with(eventName: String): StickyLiveData<*> {
        var liveData = mHashMap[eventName]
        if (liveData == null) {
            liveData = StickyLiveData<Any?>(eventName)
            mHashMap[eventName] = liveData
        }
        return liveData
    }

    inner class StickyLiveData<T>(private val mEventName: String) :
        LiveData<T>() {
        private var mStickyData: T? = null
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
            observer: Observer<in T>?,
            sticky: Boolean
        ) {
            super.observe(owner, WrapperObserver(this, observer, sticky))
            owner.lifecycle.addObserver(LifecycleEventObserver { source, event ->
                if (event == Lifecycle.Event.ON_DESTROY) {
                    mHashMap.remove(mEventName)
                }
            })
        }

    }

    companion object {
        fun get(): LiveDataBus {
            return Lazy.sLiveDataBus
        }
    }
}

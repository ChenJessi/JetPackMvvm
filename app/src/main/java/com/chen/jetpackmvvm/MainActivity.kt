package com.chen.jetpackmvvm

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import com.chen.jetpackmvvm.base.BaseActivity
import com.chen.jetpackmvvm.base.BaseSupportActivity
import com.chen.jetpackmvvm.databinding.ActivityMainBinding
import com.chen.jetpackmvvm.event.LiveDataBus
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


class MainActivity : BaseSupportActivity<MainViewModel, ActivityMainBinding>(){
    var job = Job()
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        mDatabind.vm = mViewModel
        mDatabind.click = ProxyClick()
    }

    override fun initListener() {
        job.cancel()
    }

    override fun initData() {
        LiveDataBus.with<String>("test").observe(this, Observer {
            Log.e("MainActivity","LiveDataBus   observe  : $it")
        })
        LiveDataBus.with<String>("testss").observerSticky(this, Observer {
            Log.e("MainActivity","LiveDataBus   observe  : $it")
        },false)

    }


    suspend fun test() = suspendCoroutine<String> {

        if (true){
            it.resume("success")
        } else {
            it.resumeWithException(Exception())
        }
    }

    inner class ProxyClick{
        fun test(){
            mViewModel.title.value = "点击了"
            Log.e("JetPackMVVM", "点击了======")
            startActivity(Intent(this@MainActivity, ListActivity::class.java))
        }
        fun test1(view : View){
            mViewModel.title.value = "点击了2"
            mViewModel.url.value ="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1589453601618&di=7e088f349074611696662981a532d0c2&imgtype=0&src=http%3A%2F%2Fimg.tukexw.com%2Fimg%2Fed0abc251142eb08.jpg"
//            mViewModel.testRequest()
//            LiveDataBus.with<String>("test").postValue("teset")
//            LiveDataBus.with<String>("testss").postValue("teset====")
//            LiveDataBus.get().with<String>("test").postStickyData("teset=======")
//            Log.e("JetPackMVVM", "点击了======= ces   ${isDarkTheme(this@MainActivity)}")
//            if (isDarkTheme(this@MainActivity)) {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//            } else {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//            }

        }

    }

//    fun isDarkTheme(context: Context): Boolean {
//        val flag = context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
//        return flag == Configuration.UI_MODE_NIGHT_YES
//    }

}

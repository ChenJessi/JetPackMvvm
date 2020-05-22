package com.chen.jetpackmvvm

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.chen.jetpackmvvm.base.BaseActivity
import com.chen.jetpackmvvm.base.BaseSupportActivity
import com.chen.jetpackmvvm.databinding.ActivityMainBinding
import com.chen.jetpackmvvm.event.LiveDataBus

class MainActivity : BaseSupportActivity<MainViewModel, ActivityMainBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        mDatabind.vm = mViewModel
        mDatabind.click = ProxyClick()
    }

    override fun initListener() {

    }

    override fun initData() {
        LiveDataBus.with<String>("test").observe(this, Observer {
            Log.e("MainActivity","LiveDataBus   observe  : $it")
        })
        LiveDataBus.with<String>("testss").observerSticky(this, Observer {
            Log.e("MainActivity","LiveDataBus   observe  : $it")
        },false)
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
            mViewModel.testRequest()
            LiveDataBus.with<String>("test").postValue("teset")
            LiveDataBus.with<String>("testss").postValue("teset====")
//            LiveDataBus.get().with<String>("test").postStickyData("teset=======")
            Log.e("JetPackMVVM", "点击了======= ces   ${Thread.currentThread()}")

        }
    }
}

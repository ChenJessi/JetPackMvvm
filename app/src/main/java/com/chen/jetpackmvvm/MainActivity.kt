package com.chen.jetpackmvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.chen.jetpackmvvm.base.BaseVmDbActivity
import com.chen.jetpackmvvm.data.ChaptersData
import com.chen.jetpackmvvm.databinding.ActivityMainBinding
import com.chen.jetpackmvvm.retrofit.RetrofitManager
import kotlinx.coroutines.*
import okhttp3.internal.threadName
import okhttp3.internal.wait
import java.util.*

class MainActivity : BaseVmDbActivity<MainViewModel, ActivityMainBinding>() {

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

            GlobalScope.launch(Dispatchers.Main) {
                Log.e("JetPackMVVM", "点击了======  ${Thread.currentThread()}")
                var str = withContext(Dispatchers.IO){
                    RetrofitManager.retrofit.getChapters()
                }
            }
            Log.e("JetPackMVVM", "点击了======= ces   ${Thread.currentThread()}")

        }
    }
}

package com.chen.jetpackmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.chen.jetpackmvvm.base.BaseVmDbActivity
import com.chen.jetpackmvvm.databinding.ActivityMainBinding

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
        }
        fun test1(view : View){
            mViewModel.title.value = "点击了2"
            Log.e("JetPackMVVM", "点击了======  $view")
        }
    }
}

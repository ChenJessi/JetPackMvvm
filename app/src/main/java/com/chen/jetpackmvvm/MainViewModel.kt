package com.chen.jetpackmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.NavHostFragment
import com.chen.jetpackmvvm.base.BaseViewModel
import com.chen.jetpackmvvm.data.HttpResult
import com.chen.jetpackmvvm.ext.request
import com.chen.jetpackmvvm.service.RetrofitAPI
import kotlinx.coroutines.*

class MainViewModel() : BaseViewModel() {
    var title = MutableLiveData<String>("title")
    var titles = MutableLiveData<ArrayList<String>>()
    var url = MutableLiveData<String>("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=214555343,3370061946&fm=26&gp=0.jpg")

    /**
     * 测试demo
     * 正式环境requestmodel 应 和数据 viewmodel 分离
     */
    fun testRequest(){
        /**
         * http请求
         */
        request({
                RetrofitAPI.getAPI.getChapters()
            },
            {
                title.postValue(it)
            },{
                title.postValue(it.message)
            })
    }



}



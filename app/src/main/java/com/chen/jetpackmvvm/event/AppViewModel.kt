package com.chen.jetpackmvvm.event

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.chen.jetpackmvvm.base.BaseViewModel

/**
 * 保存全局配置的ViewModel
 */
class AppViewModel : BaseViewModel() {
    /**
     * 是否是登录状态
     */
    var isLogin = UnPeekLiveData<Boolean>()
}
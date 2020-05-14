package com.chen.jetpackmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.chen.jetpackmvvm.base.BaseViewModel

class MainViewModel : BaseViewModel() {
    var title = MutableLiveData<String>("title")
    var url = MutableLiveData<String>("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=214555343,3370061946&fm=26&gp=0.jpg")

   
}
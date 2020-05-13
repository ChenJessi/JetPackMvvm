package com.chen.jetpackmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.chen.jetpackmvvm.base.BaseViewModel

class MainViewModel : BaseViewModel() {
    var title = MutableLiveData<String>("title")


}
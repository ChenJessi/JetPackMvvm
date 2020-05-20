package com.chen.jetpackmvvm.ext

import androidx.lifecycle.viewModelScope
import com.chen.jetpackmvvm.base.BaseViewModel
import com.chen.jetpackmvvm.data.HttpResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


fun <T> BaseViewModel.request(block : suspend () -> HttpResult<T>,
                              success :(T) -> Unit,
                              failure :(Throwable) -> Unit = {}){

    viewModelScope.launch (Dispatchers.Main){
        runCatching {
            withContext(Dispatchers.IO){ block() }
        }.onSuccess {
            success(it.data)
        }.onFailure {
            failure(it)
        }
    }


}
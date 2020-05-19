package com.chen.jetpackmvvm.ext

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chen.jetpackmvvm.data.HttpResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher


fun <T> ViewModel.request(block : suspend () -> HttpResult<T> ,
                          success :(T) -> Unit,
                          failure :(Exception) -> Unit = {}){

    viewModelScope.launch {
        runCatching {
            withContext(Dispatchers.IO){ block() }
        }.onSuccess {

        }.onFailure {
            
        }
    }


}
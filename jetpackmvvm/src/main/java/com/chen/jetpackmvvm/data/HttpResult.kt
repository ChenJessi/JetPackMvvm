package com.chen.jetpackmvvm.data

data class  HttpResult<T>(var data :T , var errorCode : Int = 0, var errorMsg: String = "")
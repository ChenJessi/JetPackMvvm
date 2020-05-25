package com.chen.jetpackmvvm.service

import com.chen.jetpackmvvm.retrofit.RetrofitAPI

object RetrofitAPI  {
    val baseUrl =  "https://www.wanandroid.com"
    var getAPI = RetrofitAPI().getAPI(ApiService::class.java, baseUrl)
}
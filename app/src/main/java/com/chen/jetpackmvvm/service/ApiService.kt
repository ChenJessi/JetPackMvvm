package com.chen.jetpackmvvm.service

import com.chen.jetpackmvvm.data.HttpResult
import retrofit2.http.GET

interface ApiService {
    @GET("/wxarticle/chapters/json")
    suspend fun getChapters() : HttpResult<String>
}
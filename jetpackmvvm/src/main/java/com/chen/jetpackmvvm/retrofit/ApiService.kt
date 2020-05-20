package com.chen.jetpackmvvm.retrofit

import com.chen.jetpackmvvm.data.HttpResult
import org.json.JSONObject
import retrofit2.http.GET

interface ApiService {

    @GET("/wxarticle/chapters/json1")
    suspend fun getChapters() : HttpResult<String>
}
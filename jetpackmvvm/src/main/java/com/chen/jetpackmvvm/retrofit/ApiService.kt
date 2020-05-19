package com.chen.jetpackmvvm.retrofit

import com.chen.jetpackmvvm.data.ChaptersData
import org.json.JSONObject
import retrofit2.http.GET

interface ApiService {

    @GET("/wxarticle/chapters/json1")
    suspend fun getChapters() : ChaptersData
}
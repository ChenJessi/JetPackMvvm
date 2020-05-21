package com.chen.jetpackmvvm.retrofit

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseRetrofitAPI {

    fun <T> getAPI(serverceClass: Class<T>, baseUrl: String): T {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
        return setRetrofitBuilder(retrofitBuilder).build().create(serverceClass)
    }

    abstract fun setRetrofitBuilder(builder: Retrofit.Builder): Retrofit.Builder

    abstract fun setHttpClientBuilder(builder : OkHttpClient.Builder) : OkHttpClient.Builder

    private var okHttpClient: OkHttpClient = OkHttpClient.Builder().run {
        var builder = OkHttpClient.Builder()
        builder = setHttpClientBuilder(builder)
         builder.build()
    }



}
package com.chen.jetpackmvvm.retrofit

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitManager {

    /**
     * 连接超时时间，单位s
     */
    private const val DEFAULT_CONNECT_TIMEOUT = 10L

    /**
     * 读超时时间，单位s
     */
    private const val DEFAULT_READ_TIMEOUT = 10L

    /**
     * 写超时时间，单位s
     */
    private const val DEFAULT_WRITE_TIMEOUT = 10L

    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val retrofit = Retrofit.Builder()
        .client(getOKhttpClient())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
        .baseUrl("https://www.wanandroid.com")
        .build()
        .create(ApiService::class.java)

    private fun getOKhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(getLogging())
            .build()
    }

    private fun getLogging() : HttpLoggingInterceptor{
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }


}
package com.chen.jetpackmvvm.retrofit

import com.chen.jetpackmvvm.BaseApplication
import com.chen.jetpackmvvm.ContextProvider
import com.chen.jetpackmvvm.retrofit.interceptor.CacheHeadInterceptor
import com.chen.jetpackmvvm.retrofit.interceptor.HeadInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Cache
import okhttp3.CookieJar
import okhttp3.OkHttpClient
import okhttp3.internal.cache.CacheInterceptor
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

open class RetrofitAPI : BaseRetrofitAPI() {

    /**
     * 连接超时时间，单位s
     */
    private  val DEFAULT_CONNECT_TIMEOUT = 10L

    /**
     * 读超时时间，单位s
     */
    private  val DEFAULT_READ_TIMEOUT = 10L

    /**
     * 写超时时间，单位s
     */
    private  val DEFAULT_WRITE_TIMEOUT = 10L

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()


    override fun setRetrofitBuilder(builder: Retrofit.Builder): Retrofit.Builder {
        return builder.apply {
            addConverterFactory(MoshiConverterFactory.create(moshi))
            addConverterFactory(MoshiConverterFactory.create())
            addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
        }
    }

    override fun setHttpClientBuilder(builder: OkHttpClient.Builder): OkHttpClient.Builder {
        return builder.apply {
            cache(Cache(File(ContextProvider.getContext().cacheDir, "cx_cache"), 10 * 1024 * 1024))
            connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS)
            addInterceptor(HeadInterceptor(mapOf(Pair("tokenkey","tokenvalue"))))
            addInterceptor(CacheHeadInterceptor())
            addInterceptor(getLogging())
        }
    }

    private fun getLogging() : HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}
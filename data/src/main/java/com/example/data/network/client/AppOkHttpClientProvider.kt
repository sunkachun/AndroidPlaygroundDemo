package com.example.data.network.client

import com.example.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppOkHttpClientProvider @Inject constructor() : OkHttpClientProvider {

    override val client: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .apply {
                addInterceptor(headerInterceptor)

                if (BuildConfig.DEBUG) {
                    addInterceptor(httpLoggingInterceptor)
                }
            }
            .build()
    }

    private val httpLoggingInterceptor: HttpLoggingInterceptor by lazy {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
    }

    private val headerInterceptor: Interceptor by lazy {
        Interceptor {
            it.proceed(
                it.request().newBuilder()
                    .build()
            )
        }
    }
}
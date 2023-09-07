package com.example.data.network

import com.example.data.BuildConfig
import com.example.data.network.client.AppOkHttpClientProvider
import com.example.data.weather.weatherforecast.WeatherForecastService
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GovServiceGenerator @Inject constructor(
    private val okHttpClientProvider: AppOkHttpClientProvider
) {

    fun retrofit(converterFactory: Converter.Factory = GsonConverterFactory.create()): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.GOV_WEATHER_API_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(converterFactory)
            .client(okHttpClientProvider.client)
            .build()
    }

    val weatherForecastService: WeatherForecastService by lazy { generate() }

    inline fun <reified T : Any> generate(): T {
        return retrofit().create(T::class.java)
    }
}
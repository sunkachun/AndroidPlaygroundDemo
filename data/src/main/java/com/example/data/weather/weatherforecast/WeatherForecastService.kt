package com.example.data.weather.weatherforecast

import com.example.data.weather.weatherforecast.entity.NineDayWeatherForecastResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface WeatherForecastService {

    @GET("weatherAPI/opendata/weather.php?dataType=fnd")
    fun getWeatherInformation(): Single<Response<NineDayWeatherForecastResponse>>
}
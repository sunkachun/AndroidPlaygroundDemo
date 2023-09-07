package com.example.domain.weather.weatherforecast.data

import com.example.domain.weather.weatherforecast.model.NineDayWeatherForecast
import io.reactivex.Single

interface WeatherForecastRepository {

    fun getNineDayWeatherForecast(): Single<NineDayWeatherForecast>
}
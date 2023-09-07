package com.example.domain.weather.weatherforecast

import com.example.domain.weather.weatherforecast.data.WeatherForecastRepository
import com.example.domain.weather.weatherforecast.model.NineDayWeatherForecast
import io.reactivex.Single
import javax.inject.Inject

class GetNineDayWeatherForecast @Inject constructor(
    private val repository: WeatherForecastRepository,
) {

    operator fun invoke(): Single<NineDayWeatherForecast> {
        return repository.getNineDayWeatherForecast()
    }
}
package com.example.data.weather.weatherforecast

import com.example.data.util.requireData
import com.example.domain.weather.weatherforecast.data.WeatherForecastRepository
import com.example.domain.weather.weatherforecast.model.NineDayWeatherForecast
import io.reactivex.Single
import javax.inject.Inject

class RemoteWeatherForecastRepository @Inject constructor(
    private val weatherForecastService: WeatherForecastService,
    private val mapper: WeatherMapper,
): WeatherForecastRepository {

    override fun getNineDayWeatherForecast(): Single<NineDayWeatherForecast> {
        return weatherForecastService.getWeatherInformation()
            .map { mapper.mapToNineDayWeatherForecast(it.requireData) }
    }
}
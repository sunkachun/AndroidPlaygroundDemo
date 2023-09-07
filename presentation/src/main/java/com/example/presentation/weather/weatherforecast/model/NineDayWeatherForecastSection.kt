package com.example.presentation.weather.weatherforecast.model

import com.example.domain.weather.weatherforecast.model.WeatherStatus

data class NineDayWeatherForecastSection(
    val generalDisplay: String,
    val updateTime: String,
    val weatherForecast: List<WeatherForecastDisplay>,
)

data class WeatherForecastDisplay(
    val forecastDisplayTitle: String,
    val forecastDisplayWeather: String,
    val forecastDisplayMaxTemp: String,
    val forecastDisplayMinTemp: String,
    val forecastIcon: WeatherStatus
)

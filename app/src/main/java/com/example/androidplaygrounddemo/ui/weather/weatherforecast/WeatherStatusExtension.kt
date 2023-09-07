package com.example.androidplaygrounddemo.ui.weather.weatherforecast

import com.example.androidplaygrounddemo.R
import com.example.domain.weather.weatherforecast.model.WeatherStatus

val WeatherStatus.icon: Int
    get() = when (this) {
        WeatherStatus.SUNNY -> R.drawable.ic_dashboard_button_sunny
        else -> R.drawable.ic_weather_cloudly
    }
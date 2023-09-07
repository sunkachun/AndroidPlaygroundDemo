package com.example.androidplaygrounddemo.generic.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.domain.weather.weatherforecast.model.WeatherStatus
import com.example.androidplaygrounddemo.ui.weather.weatherforecast.icon

@BindingAdapter("weatherIcon")
fun ImageView.weatherIcon(weatherStatus: WeatherStatus?) {
    weatherStatus?.icon?.let {
        setImageResource(it)
    }
}
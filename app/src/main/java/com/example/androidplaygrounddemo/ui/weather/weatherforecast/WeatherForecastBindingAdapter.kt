package com.example.androidplaygrounddemo.ui.weather.weatherforecast

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.domain.weather.weatherforecast.model.WeatherStatus

@BindingAdapter("weatherIcon")
fun ImageView.weatherIcon(weatherStatus: WeatherStatus?) {
    weatherStatus?.icon?.let {
        setImageResource(it)
    }
}
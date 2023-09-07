package com.example.androidplaygrounddemo.ui.weather.weatherforecast

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidplaygrounddemo.databinding.ItemWeatherForecastBinding
import com.example.androidplaygrounddemo.ui.generic.adapter.SimpleItemDiff
import com.example.androidplaygrounddemo.ui.weather.weatherforecast.WeatherForecastNineDayAdapter.ViewHolder
import com.example.presentation.weather.weatherforecast.model.WeatherForecastDisplay
import javax.inject.Inject

class WeatherForecastNineDayAdapter @Inject constructor() :
    ListAdapter<WeatherForecastDisplay, ViewHolder>(SimpleItemDiff { hashCode() }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemWeatherForecastBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val ui: ItemWeatherForecastBinding) : RecyclerView.ViewHolder(ui.root) {

        fun bind(forecast: WeatherForecastDisplay) {
            ui.forecast = forecast
        }
    }
}
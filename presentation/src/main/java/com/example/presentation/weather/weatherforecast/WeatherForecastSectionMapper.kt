package com.example.presentation.weather.weatherforecast

import com.example.domain.weather.weatherforecast.model.NineDayWeatherForecast
import com.example.domain.weather.weatherforecast.model.WeatherForecast
import com.example.presentation.weather.weatherforecast.model.NineDayWeatherForecastSection
import com.example.presentation.weather.weatherforecast.model.WeatherForecastDisplay
import javax.inject.Inject

class WeatherForecastSectionMapper @Inject constructor() {

    fun toSection(weather: NineDayWeatherForecast): NineDayWeatherForecastSection {
        return weather.run {
            NineDayWeatherForecastSection(
                generalDisplay = generalSituation,
                updateTime = updateTime,
                weatherForecast = weatherForecast.map { toWeatherDisplay(it) }
            )
        }
    }

    private fun toWeatherDisplay(weatherForecast: WeatherForecast): WeatherForecastDisplay {
        return weatherForecast.run {
            WeatherForecastDisplay(
                forecastDisplayTitle = "$forecastDate ($week)",
                forecastDisplayMaxTemp = forecastMaxtemp.toString(),
                forecastDisplayMinTemp = forecastMintemp.toString(),
                forecastIcon = forecastIcon,
                forecastDisplayWeather = forecastWeather
            )
        }
    }
}
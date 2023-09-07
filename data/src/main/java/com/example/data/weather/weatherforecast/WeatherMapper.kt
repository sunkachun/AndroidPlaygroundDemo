package com.example.data.weather.weatherforecast

import com.example.data.weather.weatherforecast.entity.Forecast
import com.example.data.weather.weatherforecast.entity.NineDayWeatherForecastResponse
import com.example.domain.weather.weatherforecast.model.NineDayWeatherForecast
import com.example.domain.weather.weatherforecast.model.WeatherForecast
import com.example.domain.weather.weatherforecast.model.WeatherStatus
import javax.inject.Inject

class WeatherMapper @Inject constructor() {

    fun mapToNineDayWeatherForecast(response: NineDayWeatherForecastResponse): NineDayWeatherForecast {
        return response.run {
            NineDayWeatherForecast(
                generalSituation = generalSituation,
                weatherForecast = weatherForecast.map { mapToWeatherForecast(it) },
                updateTime = updateTime,
            )
        }
    }

    private fun mapToWeatherForecast(weatherForecast: Forecast): WeatherForecast {
        return weatherForecast.run {
            WeatherForecast(
                forecastDate = forecastDate,
                week = week,
                forecastWeather = forecastWeather,
                forecastMaxtemp = forecastMaxtemp.value,
                forecastMintemp = forecastMintemp.value,
                forecastIcon = mapForecastStatus(ForecastIcon)
            )
        }
    }

    private fun mapForecastStatus(icon: Int): WeatherStatus {
        return when (icon) {
            50 -> WeatherStatus.SUNNY
            51 -> WeatherStatus.SUNNY_PERIOD
            52 -> WeatherStatus.SUNNY_INTERVALS
            53 -> WeatherStatus.SUNNY_PERIODS_WITH_A_FEW_SHOWERS
            54 -> WeatherStatus.SUNNY_INTERVALS_WITH_SHOWERS
            60 -> WeatherStatus.CLOUDY
            61 -> WeatherStatus.OVERCAST
            62 -> WeatherStatus.LIGHT_RAIN
            63 -> WeatherStatus.RAIN
            64 -> WeatherStatus.HEAVY_RAIN
            65 -> WeatherStatus.THUNDERSTORMS
            80 -> WeatherStatus.WINDY
            81 -> WeatherStatus.DRY
            82 -> WeatherStatus.HUMID
            83 -> WeatherStatus.FOG
            84 -> WeatherStatus.MIST
            85 -> WeatherStatus.HAZE
            90 -> WeatherStatus.HOT
            91 -> WeatherStatus.WARM
            92 -> WeatherStatus.COOL
            93 -> WeatherStatus.COLD
            else -> WeatherStatus.UNKNOWN
        }
    }
}
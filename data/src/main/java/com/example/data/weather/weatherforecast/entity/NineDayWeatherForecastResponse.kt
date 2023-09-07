package com.example.data.weather.weatherforecast.entity

import com.google.gson.annotations.SerializedName

data class NineDayWeatherForecastResponse(
    @SerializedName("generalSituation")
    val generalSituation: String,
    @SerializedName("weatherForecast")
    val weatherForecast: List<Forecast>,
    @SerializedName("updateTime")
    val updateTime: String,
    @SerializedName("seaTemp")
    val seaTemp: SeaTemp,
    @SerializedName("soilTemp")
    val soilTemp: List<SoilTemp>
)

data class Forecast(
    @SerializedName("forecastDate")
    val forecastDate: String,
    @SerializedName("week")
    val week: String,
    @SerializedName("forecastWind")
    val forecastWind: String,
    @SerializedName("forecastWeather")
    val forecastWeather: String,
    @SerializedName("forecastMaxtemp")
    val forecastMaxtemp: Temperature,
    @SerializedName("forecastMintemp")
    val forecastMintemp: Temperature,
    @SerializedName("forecastMaxrh")
    val forecastMaxrh: Humidity,
    @SerializedName("forecastMinrh")
    val forecastMinrh: Humidity,
    @SerializedName("ForecastIcon")
    val ForecastIcon: Int,
    @SerializedName("PSR")
    val PSR: String
)

data class Temperature(
    @SerializedName("value")
    val value: Int,
    @SerializedName("unit")
    val unit: String
)

data class Humidity(
    @SerializedName("value")
    val value: Int,
    @SerializedName("unit")
    val unit: String
)

data class SeaTemp(
    @SerializedName("place")
    val place: String,
    @SerializedName("value")
    val value: Int,
    @SerializedName("unit")
    val unit: String,
    @SerializedName("recordTime")
    val recordTime: String
)

data class SoilTemp(
    @SerializedName("place")
    val place: String,
    @SerializedName("value")
    val value: Double,
    @SerializedName("unit")
    val unit: String,
    @SerializedName("recordTime")
    val recordTime: String,
    @SerializedName("depth")
    val depth: Depth
)

data class Depth(
    @SerializedName("unit")
    val unit: String,
    @SerializedName("value")
    val value: Double
)

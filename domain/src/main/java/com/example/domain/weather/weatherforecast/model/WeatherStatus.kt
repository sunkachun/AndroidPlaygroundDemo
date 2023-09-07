package com.example.domain.weather.weatherforecast.model

enum class WeatherStatus(val caption: String) {

    SUNNY("Sunny"),
    SUNNY_PERIOD("Sunny Periods"),
    SUNNY_INTERVALS("Sunny Intervals"),
    SUNNY_PERIODS_WITH_A_FEW_SHOWERS("Sunny Periods with A Few Showers"),
    SUNNY_INTERVALS_WITH_SHOWERS("Sunny Intervals with Showers"),
    CLOUDY("Cloudy"),
    OVERCAST("Overcast"),
    LIGHT_RAIN("Light Rain"),
    RAIN("Rain"),
    HEAVY_RAIN("Heavy Rain"),
    THUNDERSTORMS("Thunderstorms"),
    WINDY("Windy"),
    DRY("Dry"),
    HUMID("Humid"),
    FOG("Fog"),
    MIST("Mist"),
    HAZE("Haze"),
    HOT("Hot"),
    WARM("Warm"),
    COOL("Cool"),
    COLD("Cold"),
    UNKNOWN("Unknown"),
}
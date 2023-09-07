package com.example.data

import com.example.data.weather.weatherforecast.RemoteWeatherForecastRepository
import com.example.domain.weather.weatherforecast.data.WeatherForecastRepository
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        AppDataModule.Bindings::class
    ]
)
class AppDataModule {

    @Module
    interface Bindings {

        @Binds
        fun bindWeatherForecastRepository(repository: RemoteWeatherForecastRepository): WeatherForecastRepository
    }
}
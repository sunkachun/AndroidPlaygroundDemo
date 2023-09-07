package com.example.androidplaygrounddemo.ui.weather.di

import com.example.androidplaygrounddemo.ui.weather.WeatherFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface WeatherFragmentModule {

    @ContributesAndroidInjector
    fun bindWeatherFragment(): WeatherFragment
}
package com.example.androidplaygrounddemo.ui.weather.weatherforecast.di

import androidx.lifecycle.ViewModel
import com.example.androidplaygrounddemo.ui.application.di.ViewModelKey
import com.example.androidplaygrounddemo.ui.application.di.ViewModelModule
import com.example.androidplaygrounddemo.ui.weather.weatherforecast.WeatherForecastFragment
import com.example.presentation.weather.weatherforecast.WeatherForecastViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface WeatherForecastFragmentModule {

    @ContributesAndroidInjector(modules = [Bindings::class, ViewModelModule::class])
    fun bindWeatherForecastFragment(): WeatherForecastFragment

    @Module
    interface Bindings {

        @Binds
        @IntoMap
        @ViewModelKey(WeatherForecastViewModel::class)
        fun bindViewModel(viewModel: WeatherForecastViewModel): ViewModel
    }
}
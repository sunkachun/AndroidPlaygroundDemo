package com.example.androidplaygrounddemo.ui.weather.di

import androidx.lifecycle.ViewModel
import com.example.androidplaygrounddemo.binding.ViewModelKey
import com.example.androidplaygrounddemo.binding.ViewModelModule
import com.example.androidplaygrounddemo.ui.weather.WeatherFragment
import com.example.presentation.weather.WeatherViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface WeatherFragmentModule {

    @ContributesAndroidInjector(modules = [Bindings::class, ViewModelModule::class])
    fun bindWeatherFragment(): WeatherFragment

    @Module
    interface Bindings {

        @Binds
        @IntoMap
        @ViewModelKey(WeatherViewModel::class)
        fun bindViewModel(viewModel: WeatherViewModel): ViewModel
    }
}
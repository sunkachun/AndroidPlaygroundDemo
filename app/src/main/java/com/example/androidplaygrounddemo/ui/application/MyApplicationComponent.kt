package com.example.androidplaygrounddemo.ui.application

import com.example.androidplaygrounddemo.ui.dashboard.di.DashboardFragmentModule
import com.example.androidplaygrounddemo.ui.di.MainActivityModule
import com.example.androidplaygrounddemo.ui.flower.di.FlowerFragmentModule
import com.example.androidplaygrounddemo.ui.home.di.HomeFragmentModule
import com.example.androidplaygrounddemo.ui.notifications.di.NotificationFragmentModule
import com.example.androidplaygrounddemo.ui.weather.di.WeatherFragmentModule
import com.example.androidplaygrounddemo.ui.weather.weatherforecast.di.WeatherForecastFragmentModule
import com.example.data.AppDataModule
import com.example.data.network.di.NetworkModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        MyApplicationModule::class,
        MainActivityModule::class,
        DashboardFragmentModule::class,
        HomeFragmentModule::class,
        NotificationFragmentModule::class,
        FlowerFragmentModule::class,
        WeatherFragmentModule::class,
        WeatherForecastFragmentModule::class,
        AppDataModule::class,
        NetworkModule::class,
    ]
)
interface MyApplicationComponent : AndroidInjector<MyApplication> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<MyApplication>
}
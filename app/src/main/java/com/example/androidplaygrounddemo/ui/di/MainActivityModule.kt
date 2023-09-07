package com.example.androidplaygrounddemo.ui.di

import androidx.appcompat.app.AppCompatActivity
import com.example.androidplaygrounddemo.MainActivity
import com.example.androidplaygrounddemo.binding.scope.ActivityScope
import com.example.androidplaygrounddemo.ui.dashboard.di.DashboardFragmentModule
import com.example.androidplaygrounddemo.ui.home.di.HomeFragmentModule
import com.example.androidplaygrounddemo.ui.notifications.di.NotificationFragmentModule
import com.example.androidplaygrounddemo.ui.flower.di.FlowerFragmentModule
import com.example.androidplaygrounddemo.ui.weather.di.WeatherFragmentModule
import com.example.androidplaygrounddemo.ui.weather.weatherforecast.di.WeatherForecastFragmentModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            DashboardFragmentModule::class,
            HomeFragmentModule::class,
            NotificationFragmentModule::class,
            FlowerFragmentModule::class,
            Bindings::class,
            WeatherFragmentModule::class,
            WeatherForecastFragmentModule::class,
        ]
    )
    fun bindMainActivity(): MainActivity

    @Module
    interface Bindings {

        @Binds
        fun bindAppCompatActivity(mainActivity: MainActivity): AppCompatActivity
    }
}
package com.example.androidplaygrounddemo.ui.di

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import com.example.androidplaygrounddemo.MainActivity
import com.example.androidplaygrounddemo.binding.scope.ActivityScope
import com.example.androidplaygrounddemo.ui.dashboard.di.DashboardFragmentModule
import com.example.androidplaygrounddemo.ui.home.di.HomeFragmentModule
import com.example.androidplaygrounddemo.ui.notifications.di.NotificationFragmentModule
import com.example.androidplaygrounddemo.ui.weather.di.WeatherFragmentModule
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
            WeatherFragmentModule::class,
            Bindings::class,
        ]
    )
    fun bindMainActivity(): MainActivity

    @Module
    interface Bindings {

        @Binds
        fun bindActivity(mainActivity: MainActivity): Activity

        @Binds
        fun bindAppCompatActivity(mainActivity: MainActivity): AppCompatActivity
    }
}
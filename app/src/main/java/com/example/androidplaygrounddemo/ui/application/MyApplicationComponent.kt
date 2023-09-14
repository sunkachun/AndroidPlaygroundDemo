package com.example.androidplaygrounddemo.ui.application

import com.example.androidplaygrounddemo.ui.di.MainActivityModule
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
        AppDataModule::class,
        NetworkModule::class,
    ]
)
interface MyApplicationComponent : AndroidInjector<MyApplication> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<MyApplication>
}
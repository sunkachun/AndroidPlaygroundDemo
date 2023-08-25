package com.example.androidplaygrounddemo.ui.home.di

import com.example.androidplaygrounddemo.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFragmentModule {

    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment
}
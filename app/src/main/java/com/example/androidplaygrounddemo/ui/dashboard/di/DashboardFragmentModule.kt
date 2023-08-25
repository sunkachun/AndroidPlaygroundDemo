package com.example.androidplaygrounddemo.ui.dashboard.di

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.example.androidplaygrounddemo.MainActivity
import com.example.androidplaygrounddemo.binding.ViewModelKey
import com.example.androidplaygrounddemo.binding.ViewModelModule
import com.example.androidplaygrounddemo.ui.dashboard.AppDashboardButtonsProvider
import com.example.androidplaygrounddemo.ui.dashboard.DashboardFragment
import com.example.presentation.dashboard.DashboardButtonsProvider
import com.example.presentation.dashboard.DashboardViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface DashboardFragmentModule {

    @ContributesAndroidInjector(modules = [Bindings::class, ViewModelModule::class])
    fun bindDashboardFragment(): DashboardFragment

    @Module
    interface Bindings {

        @Binds
        @IntoMap
        @ViewModelKey(DashboardViewModel::class)
        fun bindViewModel(viewModel: DashboardViewModel): ViewModel

        @Binds
        fun bindButtonProvider(provider: AppDashboardButtonsProvider): DashboardButtonsProvider

        @Binds
        fun bindActivity(activity: MainActivity): Activity
    }
}
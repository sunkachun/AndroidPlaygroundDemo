package com.example.androidplaygrounddemo.ui.dashboard.di

import androidx.lifecycle.ViewModel
import com.example.androidplaygrounddemo.ui.application.di.ViewModelKey
import com.example.androidplaygrounddemo.ui.application.di.ViewModelModule
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
    }
}
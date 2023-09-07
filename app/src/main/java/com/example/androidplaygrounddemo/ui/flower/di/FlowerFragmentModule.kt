package com.example.androidplaygrounddemo.ui.flower.di

import androidx.lifecycle.ViewModel
import com.example.androidplaygrounddemo.ui.application.di.ViewModelKey
import com.example.androidplaygrounddemo.ui.application.di.ViewModelModule
import com.example.androidplaygrounddemo.ui.flower.FlowerFragment
import com.example.presentation.flower.FlowerViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface FlowerFragmentModule {

    @ContributesAndroidInjector(modules = [Bindings::class, ViewModelModule::class])
    fun bindFlowerFragment(): FlowerFragment

    @Module
    interface Bindings {

        @Binds
        @IntoMap
        @ViewModelKey(FlowerViewModel::class)
        fun bindViewModel(viewModel: FlowerViewModel): ViewModel
    }
}
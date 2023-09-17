package com.example.androidplaygrounddemo.ui.todolist.detail.di

import androidx.lifecycle.ViewModel
import com.example.androidplaygrounddemo.ui.application.di.ViewModelKey
import com.example.androidplaygrounddemo.ui.application.di.ViewModelModule
import com.example.androidplaygrounddemo.ui.todolist.detail.ToDoDetailsFragment
import com.example.androidplaygrounddemo.ui.todolist.detail.ToDoDetailsFragmentArgs
import com.example.presentation.todolist.ToDoDetailViewModel
import com.example.presentation.todolist.model.ToDoDetailArgs
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface ToDoDetailsFragmentModule {

    @ContributesAndroidInjector(modules = [Bindings::class, ViewModelModule::class, Providers::class])
    fun fragment(): ToDoDetailsFragment

    @Module
    interface Bindings {

        @Binds
        @IntoMap
        @ViewModelKey(ToDoDetailViewModel::class)
        fun bindViewModel(viewModel: ToDoDetailViewModel): ViewModel
    }

    @Module
    class Providers {

        @Provides
        fun provideArgs(fragment: ToDoDetailsFragment): ToDoDetailArgs {
            val args = ToDoDetailsFragmentArgs.fromBundle(fragment.requireArguments())
            return ToDoDetailArgs(args.toDoDisplayItem)
        }
    }
}
package com.example.androidplaygrounddemo.ui.todolist.di

import androidx.lifecycle.ViewModel
import com.example.androidplaygrounddemo.ui.application.di.ViewModelKey
import com.example.androidplaygrounddemo.ui.application.di.ViewModelModule
import com.example.androidplaygrounddemo.ui.todolist.ToDoListFragment
import com.example.presentation.todolist.ToDoListViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ToDoListFragmentModule {

    @ContributesAndroidInjector(modules = [Bindings::class, ViewModelModule::class])
    abstract fun bindToDoListFragment(): ToDoListFragment

    @Module
    interface Bindings {

        @Binds
        @IntoMap
        @ViewModelKey(ToDoListViewModel::class)
        fun bindViewModel(viewModel: ToDoListViewModel): ViewModel
    }
}
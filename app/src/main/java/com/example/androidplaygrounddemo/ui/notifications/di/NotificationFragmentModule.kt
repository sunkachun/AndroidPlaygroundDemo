package com.example.androidplaygrounddemo.ui.notifications.di

import com.example.androidplaygrounddemo.ui.notifications.NotificationsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NotificationFragmentModule {

    @ContributesAndroidInjector
    abstract fun bindNotificationFragment(): NotificationsFragment
}
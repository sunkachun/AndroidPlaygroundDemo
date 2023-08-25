package com.example.androidplaygrounddemo.ui.application

import android.app.Application
import android.content.Context
import androidx.work.WorkManager
import dagger.Module
import dagger.Provides
import java.time.Clock
import java.time.ZoneId

@Module
class MyApplicationModule {

    @Provides
    fun provideApplication(application: MyApplication): Application = application

    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

    @Provides
    fun provideClock(zoneId: ZoneId): Clock = Clock.system(zoneId)

    @Provides
    fun provideWorkManager(context: Context): WorkManager = WorkManager.getInstance(context)
}
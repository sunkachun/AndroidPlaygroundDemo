package com.example.data

import android.content.Context
import com.example.data.database.AppDatabase
import com.example.data.todonote.RoomToDoNoteRepository
import com.example.data.todonote.dao.ToDoNoteDao
import com.example.data.weather.weatherforecast.RemoteWeatherForecastRepository
import com.example.domain.note.data.ToDoNoteRepository
import com.example.domain.weather.weatherforecast.data.WeatherForecastRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    includes = [
        AppDataModule.Bindings::class
    ]
)
class AppDataModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase = AppDatabase.getInstance(context)

    @Provides
    @Singleton
    fun provideNoteDao(database: AppDatabase): ToDoNoteDao = database.toDoNoteDao()

    @Module
    interface Bindings {

        @Binds
        fun bindWeatherForecastRepository(repository: RemoteWeatherForecastRepository): WeatherForecastRepository

        @Binds
        fun bindToDoNoteRepository(repository: RoomToDoNoteRepository): ToDoNoteRepository
    }
}
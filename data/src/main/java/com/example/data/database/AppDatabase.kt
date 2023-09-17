package com.example.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.todonote.dao.ToDoNoteDao
import com.example.data.todonote.model.local.ToDoNoteRoomEntity

@Database(
    entities = [ToDoNoteRoomEntity::class],
    version = 3
)
abstract class AppDatabase: RoomDatabase() {

    /**
     * Use val would be more concise and direct way to access Dao
     * Use fun more flexibility or want to enforce a standardized approach,
     * can override these functions in the subclasses of AppDatabase to provide custom implementations
     * or perform additional operations before returning the DAO instances
     */
    abstract fun toDoNoteDao(): ToDoNoteDao

    companion object {

        private const val APP_DATABASE_NAME = "app_database"

        fun getInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, APP_DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}
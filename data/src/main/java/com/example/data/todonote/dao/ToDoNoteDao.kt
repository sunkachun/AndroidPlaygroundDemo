package com.example.data.todonote.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.todonote.model.local.ToDoNoteRoomEntity
import kotlinx.coroutines.flow.Flow

/**
 * CRUD Dao for to do list app, viewmodelscope + suspend show case + coroutines
 * Can also implement it as RxKotlin, but it already have show case in weather forecast
 */
@Dao
interface ToDoNoteDao {

    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<ToDoNoteRoomEntity>>

    @Query("SELECT * FROM note WHERE id = :id")
    fun getNoteById(id: Int): ToDoNoteRoomEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: ToDoNoteRoomEntity)

    @Delete
    suspend fun deleteNote(note: ToDoNoteRoomEntity)
}
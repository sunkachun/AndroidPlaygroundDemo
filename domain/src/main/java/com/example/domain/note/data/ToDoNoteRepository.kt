package com.example.domain.note.data

import com.example.domain.note.model.ToDoNote
import kotlinx.coroutines.flow.Flow

interface ToDoNoteRepository {

    fun getNotes(): Flow<List<ToDoNote>>

    fun getNoteById(id: Int): ToDoNote?

    suspend fun insertNote(note: ToDoNote)

    suspend fun deleteNote(id: Int)
}
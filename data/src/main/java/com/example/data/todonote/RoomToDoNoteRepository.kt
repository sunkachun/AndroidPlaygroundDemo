package com.example.data.todonote

import com.example.data.todonote.dao.ToDoNoteDao
import com.example.domain.note.data.ToDoNoteRepository
import com.example.domain.note.model.ToDoNote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RoomToDoNoteRepository @Inject constructor(
    private val dao: ToDoNoteDao,
    private val mapper: ToDoNoteMapper,
): ToDoNoteRepository {
    override fun getNotes(): Flow<List<ToDoNote>> {
        return dao.getNotes().map { entities -> entities.map(mapper::mapToToDoNote) }
    }

    override fun getNoteById(id: Int): ToDoNote? {
        return dao.getNoteById(id)?.let { mapper.mapToToDoNote(it) }
    }

    override suspend fun insertNote(note: ToDoNote) {
        dao.insertNote(mapper.mapToToDoNoteEntity(note))
    }

    override suspend fun deleteNote(id: Int) {
        val item = id.let { dao.getNoteById(it) }
        if (item != null) {
            dao.deleteNote(item)
        }
    }
}
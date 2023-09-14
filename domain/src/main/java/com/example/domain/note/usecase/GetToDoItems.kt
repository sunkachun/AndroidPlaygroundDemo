package com.example.domain.note.usecase

import com.example.domain.note.data.ToDoNoteRepository
import com.example.domain.note.model.ToDoNote
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetToDoItems @Inject constructor(
    private val repository: ToDoNoteRepository,
) {

    operator fun invoke(): Flow<List<ToDoNote>> {
        return repository.getNotes()
    }
}
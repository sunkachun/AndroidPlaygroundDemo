package com.example.domain.note.usecase

import com.example.domain.note.data.ToDoNoteRepository
import com.example.domain.note.model.ToDoNote
import javax.inject.Inject

class GetToDoItem @Inject constructor(
    private val repository: ToDoNoteRepository,
) {

    operator fun invoke(id: Int): ToDoNote? {
        return repository.getNoteById(id)
    }
}
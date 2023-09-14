package com.example.domain.note.usecase

import com.example.domain.note.data.ToDoNoteRepository
import com.example.domain.note.model.ToDoNote
import javax.inject.Inject

class UpdateToDoItem @Inject constructor(
    private val repository: ToDoNoteRepository,
) {

    suspend operator fun invoke(toDoItem: ToDoNote) {
        repository.insertNote(toDoItem)
    }
}
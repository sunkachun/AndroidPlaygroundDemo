package com.example.domain.note.usecase

import com.example.domain.note.data.ToDoNoteRepository
import javax.inject.Inject

class DeleteToDoItem @Inject constructor(
    private val repository: ToDoNoteRepository,
) {

    suspend operator fun invoke(id: Int) {
        repository.deleteNote(id)
    }
}
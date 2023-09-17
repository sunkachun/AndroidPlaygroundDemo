package com.example.presentation.todolist

import com.example.domain.note.model.ToDoNote
import com.example.presentation.todolist.model.ToDoDisplayItem
import java.util.Date
import javax.inject.Inject

class ToDoDisplayMapper @Inject constructor() {

    fun toDomainItem(toDoDisplayItem: ToDoDisplayItem): ToDoNote = with(toDoDisplayItem) {
        ToDoNote(
            id = id,
            title = title,
            description = description,
            recordTime = recordTime.toLong(),
            completed = completed
        )
    }

    fun toDisplayItem(toDoNote: ToDoNote): ToDoDisplayItem = with(toDoNote) {
        ToDoDisplayItem(
            id = id,
            title = title,
            description = description,
            recordTime = Date(recordTime).toString(),
            completed = completed
        )
    }
}
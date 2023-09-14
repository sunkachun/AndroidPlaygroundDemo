package com.example.data.todonote

import com.example.data.todonote.model.local.ToDoNoteRoomEntity
import com.example.domain.note.model.ToDoNote
import javax.inject.Inject

class ToDoNoteMapper @Inject constructor() {

    fun mapToToDoNote(response: ToDoNoteRoomEntity): ToDoNote {
        return response.run {
            ToDoNote(
                id = id,
                title = title,
                description = description,
                recordTime = recordTime,
                completed = completed
            )
        }
    }

    fun mapToToDoNoteEntity(note: ToDoNote): ToDoNoteRoomEntity {
        return note.run {
            ToDoNoteRoomEntity(
                id = id,
                title = title,
                description = description,
                recordTime = recordTime,
                completed = completed
            )
        }
    }
}
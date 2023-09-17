package com.example.data.todonote.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class ToDoNoteRoomEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val title: String,
    val description:  String,
    val recordTime: Long,
    val completed: Boolean,
)

package com.example.presentation.todolist.model

import java.io.Serializable

data class ToDoDisplayItem(
    val id: Int? = null,
    val title: String,
    val description: String,
    val recordTime: String,
    val completed: Boolean,
): Serializable

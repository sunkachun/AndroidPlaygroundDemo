package com.example.presentation.todolist.model

data class ToDoDisplayItem(
    val id: Int? = null,
    val title: String,
    val description: String,
    val recordTime: String,
    val completed: Boolean,
)

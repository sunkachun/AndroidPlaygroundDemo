package com.example.presentation.todolist

import com.example.presentation.todolist.model.ToDoDisplayItem

sealed class ToDoItemAction {
    data class DeleteNote(val note: ToDoDisplayItem): ToDoItemAction()
    data class UpdateItem(val note: ToDoDisplayItem): ToDoItemAction()
}

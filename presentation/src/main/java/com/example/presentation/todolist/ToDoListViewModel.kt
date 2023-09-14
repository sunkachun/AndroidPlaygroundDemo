package com.example.presentation.todolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.note.usecase.DeleteToDoItem
import com.example.domain.note.usecase.GetToDoItem
import com.example.domain.note.usecase.GetToDoItems
import com.example.domain.note.usecase.UpdateToDoItem
import com.example.presentation.todolist.model.ToDoDisplayItem
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class ToDoListViewModel @Inject constructor(
    private val getToDoItem: GetToDoItem,
    private val getToDoItems: GetToDoItems,
    private val deleteToDoItem: DeleteToDoItem,
    private val updateToDoItem: UpdateToDoItem,
    private val mapper: ToDoDisplayMapper,
) : ViewModel() {

    private val _toDoItems = MutableLiveData<List<ToDoDisplayItem>>()
    val toDoItems: LiveData<List<ToDoDisplayItem>> by lazy {
        updateToDoItems()
        _toDoItems
    }

    private var getToDoItemsJob: Job? = null

    fun onToDoItemAction(action: ToDoItemAction) {
        viewModelScope.launch {
            when (action) {
                is ToDoItemAction.UpdateItem -> updateToDoItem(mapper.toDomainItem(action.note))
                is ToDoItemAction.DeleteNote -> deleteToDoItem(mapper.toDomainItem(action.note))
            }
        }
    }

    private fun updateToDoItems() {
        getToDoItemsJob?.cancel()
        getToDoItemsJob = getToDoItems()
            .onEach { toDoNotes -> toDoNotes.map(mapper::toDisplayItem) }
            .launchIn(viewModelScope)
    }
}
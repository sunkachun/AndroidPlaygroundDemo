package com.example.presentation.todolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.note.usecase.DeleteToDoItem
import com.example.domain.note.usecase.GetToDoItems
import com.example.presentation.todolist.model.ToDoDisplayItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class ToDoListViewModel @Inject constructor(
    private val getToDoItems: GetToDoItems,
    private val deleteToDoItem: DeleteToDoItem,
    private val mapper: ToDoDisplayMapper,
) : ViewModel() {

    private val _toDoItems = MutableLiveData<List<ToDoDisplayItem>>()
    val toDoItems: LiveData<List<ToDoDisplayItem>> by lazy {
        fetchToDoItems()
        _toDoItems
    }

    private var getToDoItemsJob: Job? = null

    fun onDeleteAction(item: ToDoDisplayItem) {
        viewModelScope.launch(Dispatchers.IO) {
            item.id?.let { deleteToDoItem(it) }
        }
    }

    private fun fetchToDoItems() {
        getToDoItemsJob?.cancel()
        getToDoItemsJob = getToDoItems()
            .onEach { toDoNotes ->
                Timber.d("chris: ${toDoNotes}")
                _toDoItems.postValue(toDoNotes.filter { it.id != null }.map(mapper::toDisplayItem))
            }
            .launchIn(viewModelScope)
    }
}
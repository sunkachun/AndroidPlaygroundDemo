package com.example.presentation.todolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.note.usecase.GetToDoItem
import com.example.domain.note.usecase.UpdateToDoItem
import com.example.presentation.todolist.model.ToDoDetailArgs
import com.example.presentation.todolist.model.ToDoDisplayItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ToDoDetailViewModel @Inject constructor(
    private val args: ToDoDetailArgs,
    private val getToDoItem: GetToDoItem,
    private val updateToDoItem: UpdateToDoItem,
    private val mapper: ToDoDisplayMapper,
) : ViewModel() {

    private val _toDoItem = MutableLiveData<ToDoDisplayItem>()
    val toDoItem: LiveData<ToDoDisplayItem> by lazy {
        fetchToDoItem()
        _toDoItem
    }

    private var getToDoItemsJob: Job? = null

    fun onUpdate(item: ToDoDisplayItem) {
        viewModelScope.launch(Dispatchers.IO) {
            updateToDoItem(mapper.toDomainItem(item))
        }
    }

    private fun fetchToDoItem() {
        args.item?.id?.let { id ->
            getToDoItemsJob?.cancel()
            getToDoItemsJob = viewModelScope.launch(Dispatchers.IO) {
                val toDoItem = getToDoItem(id)
                withContext(Dispatchers.Main) {
                    _toDoItem.value = toDoItem?.let { mapper.toDisplayItem(it) }
                }
            }
        }
    }
}
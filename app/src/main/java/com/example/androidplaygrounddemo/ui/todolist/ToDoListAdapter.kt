package com.example.androidplaygrounddemo.ui.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidplaygrounddemo.databinding.ItemToDoListBinding
import com.example.androidplaygrounddemo.ui.generic.adapter.SimpleItemDiff
import com.example.androidplaygrounddemo.ui.todolist.ToDoListAdapter.ViewHolder
import com.example.presentation.todolist.model.ToDoDisplayItem

class ToDoListAdapter(
    private val onEditClicked: (ToDoDisplayItem) -> Unit,
    private val onDeleteClicked: (ToDoDisplayItem) -> Unit,
) : ListAdapter<ToDoDisplayItem, ViewHolder>(SimpleItemDiff { recordTime }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemToDoListBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(val ui: ItemToDoListBinding) : RecyclerView.ViewHolder(ui.root) {

        fun bind(toDoListItem: ToDoDisplayItem) {
            ui.item = toDoListItem
            ui.editItem.setOnClickListener { onEditClicked(toDoListItem) }
            ui.deleteItem.setOnClickListener { onDeleteClicked(toDoListItem) }
        }
    }
}
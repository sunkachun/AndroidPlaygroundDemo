package com.example.androidplaygrounddemo.ui.todolist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.androidplaygrounddemo.R
import com.example.androidplaygrounddemo.databinding.FragmentToDoListBinding
import com.example.presentation.todolist.ToDoListViewModel
import com.example.presentation.todolist.model.ToDoDisplayItem
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ToDoListFragment : DaggerFragment(R.layout.fragment_to_do_list) {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val ui by viewBinding<FragmentToDoListBinding>()

    private val viewModel: ToDoListViewModel by viewModels { factory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.toDoItems.observe(viewLifecycleOwner, ::handleToDoList)
    }

    private fun handleToDoList(toDoDisplayItems: List<ToDoDisplayItem>?) {

    }
}
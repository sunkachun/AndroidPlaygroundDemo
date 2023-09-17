package com.example.androidplaygrounddemo.ui.todolist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.androidplaygrounddemo.R
import com.example.androidplaygrounddemo.databinding.FragmentToDoListBinding
import com.example.presentation.todolist.ToDoListViewModel
import com.example.presentation.todolist.model.ToDoDisplayItem
import dagger.android.support.DaggerFragment
import timber.log.Timber
import javax.inject.Inject

class ToDoListFragment : DaggerFragment(R.layout.fragment_to_do_list) {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val ui by viewBinding<FragmentToDoListBinding>()

    private val viewModel: ToDoListViewModel by viewModels { factory }

    private val adapter by lazy {
        ToDoListAdapter(::handleOnEditClicked, viewModel::onDeleteAction)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToDoList()
        initButton()
    }

    override fun onResume() {
        super.onResume()
        observeViewModel()
    }

    private fun initButton() {
        ui.fab.setOnClickListener {
            findNavController().navigate(ToDoListFragmentDirections.actionToDoListFragmentToToDoDetailFragment())
        }
        ui.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initToDoList() {
        ui.toDoListRecyclerView.adapter = adapter
    }

    private fun observeViewModel() {
        viewModel.toDoItems.observe(viewLifecycleOwner, ::handleToDoList)
    }

    private fun handleOnEditClicked(item: ToDoDisplayItem) {
        findNavController().navigate(
            ToDoListFragmentDirections.actionToDoListFragmentToToDoDetailFragment().setToDoDisplayItem(item)
        )
    }

    private fun handleToDoList(toDoDisplayItems: List<ToDoDisplayItem>?) {
        Timber.d("chris handleToDoList(toDoDisplayItems) ${toDoDisplayItems}")
        if (toDoDisplayItems.isNullOrEmpty()) {
            ui.toDoListEmptyView.visibility = View.VISIBLE
            ui.toDoListRecyclerView.visibility = View.GONE
        } else {
            adapter.submitList(toDoDisplayItems)
        }
    }
}
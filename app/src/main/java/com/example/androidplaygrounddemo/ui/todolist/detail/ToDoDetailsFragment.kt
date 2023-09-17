package com.example.androidplaygrounddemo.ui.todolist.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.androidplaygrounddemo.R
import com.example.androidplaygrounddemo.databinding.FragmentToDoDetailBinding
import com.example.presentation.todolist.ToDoDetailViewModel
import com.example.presentation.todolist.model.ToDoDisplayItem
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ToDoDetailsFragment : DaggerFragment(R.layout.fragment_to_do_detail) {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val ui by viewBinding<FragmentToDoDetailBinding>()

    private val viewModel: ToDoDetailViewModel by viewModels { factory }

    private var currentId: Int? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButton()
        observeViewModel()
    }

    private fun initButton() {
        ui.fab.setOnClickListener {
            val note = ToDoDisplayItem(
                id = currentId,
                title = ui.toDoTitleInput.text.toString(),
                description = ui.toDoDescriptionInput.text.toString(),
                recordTime = System.currentTimeMillis().toString(),
                completed = false
            )
            viewModel.onUpdate(note)
            findNavController().navigate(ToDoDetailsFragmentDirections.actionToDoDetailFragmentToToDoListFragment())
        }
        ui.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun observeViewModel() {
        viewModel.toDoItem.observe(viewLifecycleOwner, ::updateUI)
    }

    private fun updateUI(toDoDisplayItem: ToDoDisplayItem) {
        currentId = toDoDisplayItem.id
        ui.toDoTitleInput.setText(toDoDisplayItem.title)
        ui.toDoDescriptionInput.setText(toDoDisplayItem.description)
    }
}
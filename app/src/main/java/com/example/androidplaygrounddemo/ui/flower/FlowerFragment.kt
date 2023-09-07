package com.example.androidplaygrounddemo.ui.flower

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.androidplaygrounddemo.R
import com.example.androidplaygrounddemo.databinding.FragmentFlowerBinding
import com.example.presentation.flower.FlowerViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FlowerFragment : DaggerFragment(R.layout.fragment_flower) {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: FlowerViewModel by viewModels { factory }
    private val ui by viewBinding<FragmentFlowerBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ui.text.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
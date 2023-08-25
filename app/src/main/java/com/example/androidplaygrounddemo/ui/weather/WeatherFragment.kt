package com.example.androidplaygrounddemo.ui.weather

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.androidplaygrounddemo.R
import com.example.presentation.dashboard.DashboardViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class WeatherFragment : DaggerFragment(R.layout.fragment_weather) {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: DashboardViewModel by viewModels { factory }


}
package com.example.androidplaygrounddemo.ui.weather

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.androidplaygrounddemo.R
import com.example.androidplaygrounddemo.databinding.FragmentWeatherBinding
import dagger.android.support.DaggerFragment

class WeatherFragment : DaggerFragment(R.layout.fragment_weather) {

    private val ui by viewBinding<FragmentWeatherBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ui.weatherForecastEntry.setOnClickListener {
            findNavController().navigate(WeatherFragmentDirections.actionWeatherFragmentToWeatherForecastFragment())
        }
        ui.backButtonLayout.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
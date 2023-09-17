package com.example.androidplaygrounddemo.ui.weather.weatherforecast

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.androidplaygrounddemo.R
import com.example.androidplaygrounddemo.databinding.FragmentWeatherForecastBinding
import com.example.presentation.weather.weatherforecast.WeatherForecastViewModel
import com.example.presentation.weather.weatherforecast.model.NineDayWeatherForecastSection
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class WeatherForecastFragment : DaggerFragment(R.layout.fragment_weather_forecast) {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val adapter = WeatherForecastNineDayAdapter()

    private val ui by viewBinding<FragmentWeatherForecastBinding>()

    private val viewModel: WeatherForecastViewModel by viewModels { factory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initForecastList()
    }

    override fun onStart() {
        super.onStart()
        observeViewModel()
        ui.backButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroy() {
        ui.weatherForecastRC.adapter = null
        super.onDestroy()
    }

    private fun observeViewModel() {
        viewModel.nineDayWeatherForecast.observe(viewLifecycleOwner, ::showWeatherForecast)
    }

    private fun showWeatherForecast(nineDayWeatherForecastSection: NineDayWeatherForecastSection) {
        adapter.submitList(nineDayWeatherForecastSection.weatherForecast)
    }

    private fun initForecastList() {
        ui.weatherForecastRC.adapter = adapter
    }
}
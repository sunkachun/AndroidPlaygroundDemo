package com.example.presentation.weather.weatherforecast

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.weather.weatherforecast.GetNineDayWeatherForecast
import com.example.presentation.extension.observeOnMain
import com.example.presentation.extension.subscribeOnIO
import com.example.presentation.weather.weatherforecast.model.NineDayWeatherForecastSection
import io.reactivex.disposables.Disposable
import timber.log.Timber
import javax.inject.Inject

class WeatherForecastViewModel @Inject constructor(
    private val getNineDayWeatherForecast: GetNineDayWeatherForecast,
    private val mapper: WeatherForecastSectionMapper,
) : ViewModel() {

    private var disposable: Disposable? = null

    private val _nineDayWeatherForecast = MutableLiveData<NineDayWeatherForecastSection>()
    val nineDayWeatherForecast: LiveData<NineDayWeatherForecastSection> by lazy {
        fetchNineDayWeatherForecast()
        _nineDayWeatherForecast
    }

    private fun fetchNineDayWeatherForecast() {
        disposable = getNineDayWeatherForecast()
            .map { mapper.toSection(it) }
            .subscribeOnIO()
            .observeOnMain()
            .subscribe(_nineDayWeatherForecast::postValue, Timber::e)
    }
}
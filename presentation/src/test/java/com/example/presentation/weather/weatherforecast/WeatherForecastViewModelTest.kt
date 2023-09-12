package com.example.presentation.weather.weatherforecast

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.weather.weatherforecast.GetNineDayWeatherForecast
import com.example.domain.weather.weatherforecast.model.NineDayWeatherForecast
import com.example.presentation.generic.AppRxMockitoJUnitRunner
import com.example.presentation.weather.weatherforecast.model.NineDayWeatherForecastSection
import com.jraska.livedata.test
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.kotlin.given
import org.mockito.kotlin.mock


@RunWith(AppRxMockitoJUnitRunner::class)
class WeatherForecastViewModelTest {

    @get:Rule
    val liveDataRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var getNineDayWeatherForecast: GetNineDayWeatherForecast

    @Mock
    private lateinit var mapper: WeatherForecastSectionMapper

    @InjectMocks
    private lateinit var viewModel: WeatherForecastViewModel

    @Test
    fun `when weather is observed, then weather section is mapped and value is emitted`() {
        // Given
        val weather = mock<NineDayWeatherForecast>()
        val weatherSection = mock<NineDayWeatherForecastSection>()
        given(getNineDayWeatherForecast()).willReturn(Single.just(weather))
        given(mapper.toSection(weather)).willReturn(weatherSection)

        // When
        val result = viewModel.nineDayWeatherForecast.test()

        // Then
        result.assertValue(weatherSection)
    }
}
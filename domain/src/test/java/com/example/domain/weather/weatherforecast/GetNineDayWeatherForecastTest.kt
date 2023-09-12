package com.example.domain.weather.weatherforecast

import com.example.domain.weather.weatherforecast.data.WeatherForecastRepository
import com.example.domain.weather.weatherforecast.model.NineDayWeatherForecast
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.given
import org.mockito.kotlin.mock

@RunWith(MockitoJUnitRunner::class)
class GetNineDayWeatherForecastTest {

    @Mock
    private lateinit var repository: WeatherForecastRepository

    @InjectMocks
    private lateinit var getNineDayWeatherForecast: GetNineDayWeatherForecast

    @Test
    fun `Verify weather is fetched with chosen unit system and returned`(){
        // Given
        val weather = mock<NineDayWeatherForecast>()

        given(repository.getNineDayWeatherForecast()).willReturn(Single.just(weather))

        // When
        val result = getNineDayWeatherForecast().test()

        // Then
        result.assertValue(weather)
    }
}
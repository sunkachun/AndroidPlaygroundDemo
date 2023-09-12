package com.example.data.weather.weatherforecast

import com.example.data.weather.weatherforecast.entity.NineDayWeatherForecastResponse
import com.example.domain.weather.weatherforecast.model.NineDayWeatherForecast
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.given
import org.mockito.kotlin.mock
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class RemoteWeatherForecastRepositoryTest {

    @Mock
    private lateinit var weatherForecastService: WeatherForecastService

    @Mock
    private lateinit var mapper: WeatherMapper

    @InjectMocks
    private lateinit var repository: RemoteWeatherForecastRepository

    @Test
    fun `Verify result from weather forecast service is mapped and returned`() {
        // Given
        val weatherForecastResponse = mock<NineDayWeatherForecastResponse>()
        val response = Response.success(weatherForecastResponse)
        val weatherForecast = mock<NineDayWeatherForecast>()

        given(weatherForecastService.getWeatherInformation()).willReturn(Single.just(response))
        given(mapper.mapToNineDayWeatherForecast(weatherForecastResponse)).willReturn(weatherForecast)

        // When
        val result = repository.getNineDayWeatherForecast().test()

        // Then
        result.assertValue(weatherForecast)
    }
}
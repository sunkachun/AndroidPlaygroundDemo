package com.example.data.weather.weatherforecast

import com.example.data.weather.weatherforecast.entity.Depth
import com.example.data.weather.weatherforecast.entity.Forecast
import com.example.data.weather.weatherforecast.entity.Humidity
import com.example.data.weather.weatherforecast.entity.NineDayWeatherForecastResponse
import com.example.data.weather.weatherforecast.entity.SeaTemp
import com.example.data.weather.weatherforecast.entity.SoilTemp
import com.example.data.weather.weatherforecast.entity.Temperature
import com.example.domain.weather.weatherforecast.model.NineDayWeatherForecast
import com.example.domain.weather.weatherforecast.model.WeatherForecast
import com.example.domain.weather.weatherforecast.model.WeatherStatus
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertEquals

@RunWith(MockitoJUnitRunner::class)
class WeatherMapperTest {

    @InjectMocks
    private lateinit var mapper: WeatherMapper

    @Test
    fun `Verify metric weather is mapped correctly`() {
        // Given
        val response = createNineDayWeatherForecastResponse()

        // When
        val result = mapper.mapToNineDayWeatherForecast(response)

        // Then
        val expected = createNineDayWeatherForecast()
        assertEquals(
            result,
            expected
        )
    }

    @Test
    fun `Map sunny periods to sunny period status`() {
        testWeatherStatus(51, WeatherStatus.SUNNY_PERIOD)
    }

    @Test
    fun `Map sunny intervals to sunny intervals status`() {
        testWeatherStatus(52, WeatherStatus.SUNNY_INTERVALS)
    }

    @Test
    fun `Map sunny periods with a few showers to sunny periods with a few showers status`() {
        testWeatherStatus(53, WeatherStatus.SUNNY_PERIODS_WITH_A_FEW_SHOWERS)
    }

    @Test
    fun `Map sunny intervals with showers to sunny intervals with showers status`() {
        testWeatherStatus(54, WeatherStatus.SUNNY_INTERVALS_WITH_SHOWERS)
    }

    @Test
    fun `Map cloudy to cloudy status`() {
        testWeatherStatus(60, WeatherStatus.CLOUDY)
    }

    @Test
    fun `Map overcast to overcast status`() {
        testWeatherStatus(61, WeatherStatus.OVERCAST)
    }

    @Test
    fun `Map light rain to light rain status`() {
        testWeatherStatus(62, WeatherStatus.LIGHT_RAIN)
    }

    @Test
    fun `Map heavy rain to heavy rain status`() {
        testWeatherStatus(64, WeatherStatus.HEAVY_RAIN)
    }

    @Test
    fun `Map thunderstorms to thunderstorms status`() {
        testWeatherStatus(65, WeatherStatus.THUNDERSTORMS)
    }

    @Test
    fun `Map windy to windy status`() {
        testWeatherStatus(80, WeatherStatus.WINDY)
    }

    @Test
    fun `Map dry to dry status`() {
        testWeatherStatus(81, WeatherStatus.DRY)
    }

    @Test
    fun `Map humid to humid status`() {
        testWeatherStatus(82, WeatherStatus.HUMID)
    }

    @Test
    fun `Map fog to fog status`() {
        testWeatherStatus(83, WeatherStatus.FOG)
    }

    @Test
    fun `Map mist to mist status`() {
        testWeatherStatus(84, WeatherStatus.MIST)
    }

    @Test
    fun `Map haze to haze status`() {
        testWeatherStatus(85, WeatherStatus.HAZE)
    }

    @Test
    fun `Map hot to hot status`() {
        testWeatherStatus(90, WeatherStatus.HOT)
    }

    @Test
    fun `Map warm to warm status`() {
        testWeatherStatus(91, WeatherStatus.WARM)
    }

    @Test
    fun `Map cool to cool status`() {
        testWeatherStatus(92, WeatherStatus.COOL)
    }

    @Test
    fun `Map cold to cold status`() {
        testWeatherStatus(93, WeatherStatus.COLD)
    }

    @Test
    fun `Map unknown to unknown status`() {
        testWeatherStatus(1324123, WeatherStatus.UNKNOWN)
    }

    private fun testWeatherStatus(icon: Int, weatherStatus: WeatherStatus) {
        // Given
        val response = createNineDayWeatherForecastResponse(forecastList = listOf(createForecast(forecastIcon = icon)))

        // When
        val result = mapper.mapToNineDayWeatherForecast(response)

        // Then
        assertEquals(
            result.weatherForecast[0].forecastIcon,
            weatherStatus
        )
    }

    private fun createNineDayWeatherForecastResponse(
        generalSituation: String = "Some general situation",
        forecastList: List<Forecast> = listOf(createForecast()),
        updateTime: String = "2023-09-12 18:00:00",
        seaTemp: SeaTemp = createSeaTemp(),
        soilTempList: List<SoilTemp> = listOf(createSoilTemp())
    ): NineDayWeatherForecastResponse {
        return NineDayWeatherForecastResponse(
            generalSituation = generalSituation,
            weatherForecast = forecastList,
            updateTime = updateTime,
            seaTemp = seaTemp,
            soilTemp = soilTempList
        )
    }

    private fun createForecast(
        forecastDate: String = "2023-09-13",
        week: String = "Wednesday",
        forecastWind: String = "Moderate",
        forecastWeather: String = "Sunny",
        forecastMaxtemp: Temperature = Temperature(value = 30, unit = "Celsius"),
        forecastMintemp: Temperature = Temperature(value = 20, unit = "Celsius"),
        forecastMaxrh: Humidity = Humidity(value = 80, unit = "%"),
        forecastMinrh: Humidity = Humidity(value = 50, unit = "%"),
        forecastIcon: Int = 50,
        PSR: String = "Some PSR"
    ): Forecast {
        return Forecast(
            forecastDate = forecastDate,
            week = week,
            forecastWind = forecastWind,
            forecastWeather = forecastWeather,
            forecastMaxtemp = forecastMaxtemp,
            forecastMintemp = forecastMintemp,
            forecastMaxrh = forecastMaxrh,
            forecastMinrh = forecastMinrh,
            ForecastIcon = forecastIcon,
            PSR = PSR
        )
    }

    private fun createSeaTemp(
        place: String = "Some place",
        value: Int = 28,
        unit: String = "Celsius",
        recordTime: String = "2023-09-12 18:00:00"
    ): SeaTemp {
        return SeaTemp(
            place = place,
            value = value,
            unit = unit,
            recordTime = recordTime
        )
    }

    private fun createSoilTemp(
        place: String = "Some place",
        value: Double = 25.5,
        unit: String = "Celsius",
        recordTime: String = "2023-09-12 18:00:00",
        depth: Depth = createDepth()
    ): SoilTemp {
        return SoilTemp(
            place = place,
            value = value,
            unit = unit,
            recordTime = recordTime,
            depth = depth
        )
    }

    private fun createDepth(
        unit: String = "cm",
        value: Double = 10.0
    ): Depth {
        return Depth(
            unit = unit,
            value = value
        )
    }

    fun createNineDayWeatherForecast(
        generalSituation: String = "Some general situation",
        updateTime: String = "2023-09-12 18:00:00",
        weatherForecast: List<WeatherForecast> = listOf(createWeatherForecast())
    ): NineDayWeatherForecast {
        return NineDayWeatherForecast(generalSituation, updateTime, weatherForecast)
    }

    private fun createWeatherForecast(
        forecastDate: String = "2023-09-13",
        week: String = "Wednesday",
        forecastWeather: String = "Sunny",
        forecastMaxtemp: Int = 30,
        forecastMintemp: Int = 20,
        forecastIcon: WeatherStatus = WeatherStatus.SUNNY
    ): WeatherForecast {
        return WeatherForecast(forecastDate, week, forecastWeather, forecastMaxtemp, forecastMintemp, forecastIcon)
    }
}
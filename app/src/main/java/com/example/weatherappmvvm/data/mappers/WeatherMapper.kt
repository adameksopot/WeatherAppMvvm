package com.example.weatherappmvvm.data.mappers

import com.example.weatherappmvvm.data.WeatherHourlyResponse
import com.example.weatherappmvvm.data.WeatherResponse
import com.example.weatherappmvvm.domain.model.WeatherData
import com.example.weatherappmvvm.domain.model.WeatherInfo
import com.example.weatherappmvvm.domain.model.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


private data class WeatherDataIndexHelper(val index: Int, val data: WeatherData)

private fun WeatherHourlyResponse.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]

        WeatherDataIndexHelper(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                tempC = temperature,
                pressure = pressure,
                weatherType = WeatherType.fromWMO(weatherCode),
                humidity = humidity,
                windSpeed = windSpeed
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map { data -> data.data }
    }
}

fun WeatherResponse.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeather = weatherDataMap[0]?.find {
        val hour = if (now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }
    return WeatherInfo(
        weatherDataForADay = weatherDataMap,
        currentWeatherData = currentWeather
    )
}

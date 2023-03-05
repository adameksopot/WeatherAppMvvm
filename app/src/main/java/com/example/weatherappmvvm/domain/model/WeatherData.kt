package com.example.weatherappmvvm.domain.model

import java.time.LocalDateTime

data class WeatherData(
    val time: LocalDateTime,
    val tempC: Double,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double,
    val weatherType: WeatherType
)

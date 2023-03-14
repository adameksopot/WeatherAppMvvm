package com.example.weatherappmvvm.util

import com.example.weatherappmvvm.domain.model.WeatherData
import com.example.weatherappmvvm.domain.model.WeatherType
import java.time.LocalDateTime

class WeatherTestData {
    val data = WeatherData(
        time = LocalDateTime.now(),
        1.toDouble(),1.toDouble(),1.toDouble(),1.toDouble(),
        weatherType = WeatherType.ClearSky
    )
}
package com.example.weatherappmvvm.domain.model

data class WeatherInfo(
    val weatherDataForADay: Map<Int, List<WeatherData>>,
    val currentWeatherData: WeatherData?,
)
package com.example.weatherappmvvm.presentation

import com.example.weatherappmvvm.domain.model.WeatherInfo

data class WeatherState(
    val data: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)
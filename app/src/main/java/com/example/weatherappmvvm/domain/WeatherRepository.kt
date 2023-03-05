package com.example.weatherappmvvm.domain

import com.example.weatherappmvvm.domain.model.WeatherInfo
import com.example.weatherappmvvm.util.Resource

interface WeatherRepository {

    suspend fun getWeatherData(latitude: Double, longitude: Double): Resource<WeatherInfo>

}
package com.example.weatherappmvvm.data.repository

import com.example.weatherappmvvm.data.WeatherApi
import com.example.weatherappmvvm.data.mappers.toWeatherInfo
import com.example.weatherappmvvm.domain.WeatherRepository
import com.example.weatherappmvvm.domain.model.WeatherInfo
import com.example.weatherappmvvm.util.Resource
import java.lang.Exception
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi) : WeatherRepository {
    override suspend fun getWeatherData(latitude: Double, longitude: Double): Resource<WeatherInfo> {
        return try {
            val data = api.getWeatherData(latitude, longitude)
            Resource.Success(data.toWeatherInfo())
        } catch (e: Exception) {
            Resource.Error(e.message.orEmpty())
        }
    }
}
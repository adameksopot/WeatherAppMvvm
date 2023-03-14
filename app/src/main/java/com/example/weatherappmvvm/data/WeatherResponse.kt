package com.example.weatherappmvvm.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherResponse(
    @SerializedName("hourly") val weatherData: WeatherHourlyResponse
) 



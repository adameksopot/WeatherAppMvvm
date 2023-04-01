package com.example.weatherappmvvm.presentation.ui

interface WeatherDestination {
    val route: String
}

object WeatherOverview : WeatherDestination {
    override val route: String = "main"
}

object WeatherDetailsPerDay : WeatherDestination {
    override val route: String = "details"
}
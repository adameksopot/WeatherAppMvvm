package com.example.weatherappmvvm.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappmvvm.domain.LocationTracker
import com.example.weatherappmvvm.domain.WeatherRepository
import com.example.weatherappmvvm.presentation.WeatherState
import com.example.weatherappmvvm.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker
) : ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set


    fun loadWeatherInfo() {
        viewModelScope.launch {
            state = state.copy(isLoading = true, error = null)
            locationTracker.getCurrentLocation()?.let { location ->
                when (val result = repository.getWeatherData(location.latitude, location.longitude)) {
                    is Resource.Success -> state = state.copy(data = result.data, isLoading = false, error = null)
                    is Resource.Error ->
                        state = state.copy(data = null, isLoading = false, error = result.message)
                }
            } ?: run {
                state = state.copy(
                    isLoading = false,
                    error = "Couldn't retrieve location. Make sure to grant permission and enable GPS."
                )
            }
        }
    }
}
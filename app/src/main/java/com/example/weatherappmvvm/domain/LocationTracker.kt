package com.example.weatherappmvvm.domain

import android.location.Location

interface LocationTracker {
    suspend fun getCurrentLocation() : Location?
}
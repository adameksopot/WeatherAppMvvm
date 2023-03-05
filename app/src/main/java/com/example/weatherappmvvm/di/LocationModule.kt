package com.example.weatherappmvvm.di

import com.example.weatherappmvvm.data.location.LocationTrackerImpl
import com.example.weatherappmvvm.domain.LocationTracker
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LocationModule {

    @Binds
    @Singleton
    abstract fun bindLocationTracker(defaultLocationTracker: LocationTrackerImpl): LocationTracker
}
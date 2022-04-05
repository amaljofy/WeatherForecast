package com.gadgeon_mt.weatherforecast.di

import com.gadgeon_mt.weatherforecast.base.BaseRepository
import com.gadgeon_mt.weatherforecast.model.WeatherData
import com.gadgeon_mt.weatherforecast.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    internal abstract fun bindWeatherRepository(WeatherRepository: WeatherRepository): BaseRepository<WeatherData>
}
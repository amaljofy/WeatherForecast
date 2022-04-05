package com.gadgeon_mt.weatherforecast.repository

import android.content.Context
import com.gadgeon_mt.weatherforecast.base.BaseRepository
import com.gadgeon_mt.weatherforecast.database.WeatherDao
import com.gadgeon_mt.weatherforecast.database.asDomainModel
import com.gadgeon_mt.weatherforecast.di.IoDispatcher
import com.gadgeon_mt.weatherforecast.model.WeatherData
import com.gadgeon_mt.weatherforecast.model.asDatabaseModel
import com.gadgeon_mt.weatherforecast.network.ApiService
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(
    private val dao: WeatherDao,
    private val api: ApiService,
    context: Context,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : BaseRepository<WeatherData>(context, ioDispatcher) {

    override suspend fun fetch(url: String?): WeatherData = api.getWeatherData(
        id = "524901",
        appId = "7248734965e9721707912fc99ac77247",
        units = "metric",
        latitude = 9.9470,
        longitude = 76.6359
    )

    override suspend fun saveFetchResult(t: WeatherData) {
        dao.insert(t.asDatabaseModel())
    }
    override suspend fun query(id: String?): WeatherData? =
        dao.getWeatherData()?.asDomainModel()

}
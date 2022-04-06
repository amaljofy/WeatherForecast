package com.gadgeon_mt.weatherforecast.viewmodel

import androidx.lifecycle.viewModelScope
import com.gadgeon_mt.weatherforecast.base.BaseRepository
import com.gadgeon_mt.weatherforecast.base.BaseViewModel
import com.gadgeon_mt.weatherforecast.database.WeatherDao
import com.gadgeon_mt.weatherforecast.model.WeatherData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import java.util.*
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    repository: BaseRepository<WeatherData>,
    dao: WeatherDao,
) : BaseViewModel<WeatherData>(repository){

    init {
        viewModelScope.launch {
            val data = dao.getWeatherData()
            Timber.e(data?.placeName)
        }
    }
}
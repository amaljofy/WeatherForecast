package com.gadgeon_mt.weatherforecast.viewmodel

import com.gadgeon_mt.weatherforecast.base.BaseRepository
import com.gadgeon_mt.weatherforecast.base.BaseViewModel
import com.gadgeon_mt.weatherforecast.model.WeatherData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    repository: BaseRepository<WeatherData>
) : BaseViewModel<WeatherData>(repository)
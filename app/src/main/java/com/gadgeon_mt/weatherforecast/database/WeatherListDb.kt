package com.gadgeon_mt.weatherforecast.database

data class WeatherListDb (
    val temp_min: Double,
    val temp_max: Double,
    val humidity: Double,
    val dateTime: String,
)
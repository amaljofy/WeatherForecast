package com.gadgeon_mt.weatherforecast.database

import androidx.room.TypeConverter
import com.google.gson.Gson

class WeatherConverter {

    @TypeConverter
    fun jsonToList(value: String): List<WeatherListDb> =
        Gson().fromJson(value, Array<WeatherListDb>::class.java).toList()

    @TypeConverter
    fun listToJson(value: List<WeatherListDb?>) = Gson().toJson(value.filterNotNull())
}
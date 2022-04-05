package com.gadgeon_mt.weatherforecast.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weatherDb: WeatherDb)

    @Query("SELECT * FROM weather_table")
    suspend fun getWeatherData(): WeatherDb?
}
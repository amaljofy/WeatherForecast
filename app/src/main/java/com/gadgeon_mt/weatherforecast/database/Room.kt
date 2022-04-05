package com.gadgeon_mt.weatherforecast.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [WeatherDb::class], version = 1, exportSchema = false)
@TypeConverters(WeatherConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun WeatherDao(): WeatherDao
}
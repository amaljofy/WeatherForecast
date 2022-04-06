package com.gadgeon_mt.weatherforecast.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.gadgeon_mt.weatherforecast.model.City
import com.gadgeon_mt.weatherforecast.model.WeatherData
import com.gadgeon_mt.weatherforecast.model.WeatherList
import com.gadgeon_mt.weatherforecast.model.WeatherMain

@Entity(tableName = "weather_table")
@TypeConverters(WeatherConverter::class)
data class WeatherDb(
    val placeName: String,
    val weatherListDb: List<WeatherListDb>,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)

fun WeatherDb.asDomainModel(): WeatherData {
    return WeatherData(
        city = City(
            name = this.placeName
        ),
        weatherList = this.weatherListDb.map {
            WeatherList(
                dtTxt = it.dateTime,
                main = WeatherMain(tempMax = it.temp_max, tempMin = it.temp_min, humidity = it.humidity)
            )
        } as ArrayList<WeatherList>
    )
}
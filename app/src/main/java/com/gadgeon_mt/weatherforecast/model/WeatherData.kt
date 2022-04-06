package com.gadgeon_mt.weatherforecast.model

import com.gadgeon_mt.weatherforecast.database.WeatherDb
import com.gadgeon_mt.weatherforecast.database.WeatherListDb
import com.google.gson.annotations.SerializedName

data class WeatherData(
    @SerializedName("message")
    var message: Int? = null,
    @SerializedName("list")
    var weatherList: ArrayList<WeatherList> = arrayListOf(),
    @SerializedName("city")
    var city: City? = City()
)

fun WeatherData.asDatabaseModel(): WeatherDb {
    return WeatherDb(
        placeName = this.city?.name!!,
        weatherListDb = this.weatherList.map {
            WeatherListDb(it.main?.tempMin!!,it.main?.tempMax!!,it.main?.humidity!!,it.dtTxt!!)
        }
    )
}
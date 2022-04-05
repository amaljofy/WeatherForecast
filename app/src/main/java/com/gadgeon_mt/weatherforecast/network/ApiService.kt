package com.gadgeon_mt.weatherforecast.network

import com.gadgeon_mt.weatherforecast.model.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("forecast")
    suspend fun getWeatherData(
        @Query("id") id: String,
        @Query("appid") appId: String,
        @Query("units") units: String,
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double
    ): WeatherData
}
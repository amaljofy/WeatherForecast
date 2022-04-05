package com.gadgeon_mt.weatherforecast.model

import com.google.gson.annotations.SerializedName

data class WeatherMain(
    @SerializedName("temp")
    var temp: Double? = null,
    @SerializedName("feels_like")
    var feelsLike: Double? = null,
    @SerializedName("temp_min")
    var tempMin: Double? = null,
    @SerializedName("temp_max")
    var tempMax: Double? = null,
    @SerializedName("pressure")
    var pressure: Int? = null,
    @SerializedName("sea_level")
    var seaLevel: Int? = null,
    @SerializedName("grnd_level")
    var grndLevel: Int? = null,
    @SerializedName("humidity")
    var humidity: Double? = null,
    @SerializedName("temp_kf")
    var tempKf: Double? = null
)
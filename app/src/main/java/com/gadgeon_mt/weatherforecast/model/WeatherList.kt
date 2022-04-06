package com.gadgeon_mt.weatherforecast.model

import com.google.gson.annotations.SerializedName

data class WeatherList(

    @SerializedName("dt")
    var dt: Int? = null,
    @SerializedName("main")
    var main: WeatherMain? = WeatherMain(),
    @SerializedName("dt_txt")
    var dtTxt: String? = null
)
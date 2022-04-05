package com.gadgeon_mt.weatherforecast.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.gadgeon_mt.weatherforecast.ui.theme.WeatherTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme {
                DashboardScreen()
            }
        }
    }
}
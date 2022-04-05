package com.gadgeon_mt.weatherforecast.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.gadgeon_mt.weatherforecast.R
import com.gadgeon_mt.weatherforecast.ui.commom.ProgressScreen

@Composable
fun DashboardScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text(text = stringResource(id = R.string.label_dashboard))
                    }
                },
                elevation = 8.dp
            )
        },
        content = {
            ProgressScreen()
        })
}
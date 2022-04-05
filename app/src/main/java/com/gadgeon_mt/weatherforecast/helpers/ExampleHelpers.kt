package com.gadgeon_mt.weatherforecast.helpers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.gadgeon_mt.weatherforecast.R
import com.gadgeon_mt.weatherforecast.ui.theme.WeatherTheme


@Composable
fun ExampleColumn(content: @Composable () -> Unit) {
    WeatherTheme() {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            content()
        }
    }
}

@Composable
fun ExampleText(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Int = R.color.text_default
) {
    Text(
        text = text,
        color = colorResource(id = textColor),
        modifier = modifier.padding(vertical = 12.dp)
    )
}

@Composable
fun ExampleDivider(modifier: Modifier = Modifier) {
    Divider(modifier = modifier.padding(vertical = 12.dp))
}

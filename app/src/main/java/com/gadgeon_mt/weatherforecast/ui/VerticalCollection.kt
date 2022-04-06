package com.gadgeon_mt.weatherforecast.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gadgeon_mt.weatherforecast.R
import com.gadgeon_mt.weatherforecast.model.WeatherData
import com.gadgeon_mt.weatherforecast.model.WeatherList
import com.gadgeon_mt.weatherforecast.ui.theme.WeatherFont
import com.gadgeon_mt.weatherforecast.utils.dimenToSp
import com.gadgeon_mt.weatherforecast.utils.fontWeight

@Composable
fun VerticalCollection(weatherData: WeatherData) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
    ) {
        items(
            items = weatherData.weatherList,
            itemContent = { list ->
                VerticalListItem(list, weatherData.city?.name!!)
                ListItemDivider()
            }
        )
    }

}

@Composable
private fun VerticalListItem(list: WeatherList, cityName: String) {
    val verticalSpacing = dimensionResource(id = R.dimen.weather__spacing_inner_vert)
    val horizontalSpacing = dimensionResource(id = R.dimen.weather__spacing_inner_horiz)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.weather__standard__spacing_inner))
            .testTag("banner_row")
            .background(
                color = colorResource(id = R.color.teal_700),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = horizontalSpacing, vertical = verticalSpacing)
    ) {
        WeatherRow(headingText = "City Name :", valueText = cityName)
        Spacer(
            modifier = Modifier.height(
                dimensionResource(id = R.dimen.weather__stacked__spacing_between)
            )
        )
        WeatherRow(headingText = "Temperature Min :", valueText = list.main?.tempMin!!.toString()+"°C")
        Spacer(
            modifier = Modifier.height(
                dimensionResource(id = R.dimen.weather__stacked__spacing_between)
            )
        )
        WeatherRow(
            headingText = "Temperature Max :",
            valueText = list.main?.tempMax.toString()+"°C"
        )
        Spacer(
            modifier = Modifier.height(
                dimensionResource(id = R.dimen.weather__stacked__spacing_between)
            )
        )
        WeatherRow(
            headingText = "Humidity :",
            valueText = list.main?.humidity.toString()+"%"
        )
        Spacer(
            modifier = Modifier.height(
                dimensionResource(id = R.dimen.weather__stacked__spacing_between)
            )
        )
        WeatherRow(headingText = "Date Time :", valueText = list.dtTxt!!)
    }
}

@Composable
private fun ListItemDivider() {
    Divider(
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f)
    )
}

@Composable
private fun WeatherRow(
    headingText: String,
    valueText: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        WeatherHeadingText(heading = headingText)
        Spacer(
            modifier = Modifier.width(dimensionResource(id = R.dimen.weather__inline__spacing_between))
        )
        WeatherValueText(value = valueText)
    }
}

@Composable
private fun WeatherHeadingText(heading: String) {
    Text(
        text = heading,
        color = colorResource(id = R.color.weather__heading__text_color),
        fontWeight = fontWeight(id = R.integer.weather__heading__font_weight),
        lineHeight = dimenToSp(id = R.dimen.weather__heading__font_line_height),
        fontSize = dimenToSp(id = R.dimen.weather__heading__font_size),
        textAlign = TextAlign.Start,
        fontFamily = WeatherFont,
        modifier = Modifier
            .testTag("weather_text")
            .semantics { heading() }
            .focusable(true)
    )
}

@Composable
private fun WeatherValueText(value: String) {
    Text(
        text = value,
        color = colorResource(id = R.color.weather__value__text_color),
        fontWeight = fontWeight(id = R.integer.weather__value__font_weight),
        lineHeight = dimenToSp(id = R.dimen.weather__value__font_line_height),
        fontSize = dimenToSp(id = R.dimen.weather__value__font_size),
        textAlign = TextAlign.Start,
        fontFamily = WeatherFont,
        modifier = Modifier
            .testTag("value_text")
            .focusable(true)
    )
}

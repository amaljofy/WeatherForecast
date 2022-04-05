package com.gadgeon_mt.weatherforecast.ui.theme

import androidx.annotation.ColorRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.android.sample.app.ui.theme.Shapes
import com.android.sample.app.ui.theme.Typography
import com.gadgeon_mt.weatherforecast.R

@Composable
fun WeatherTheme(
    @ColorRes primaryColor: Int = R.color.background_action__default,
    @ColorRes secondaryColor: Int = R.color.background_base,
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colors = weatherThemeColors(primaryColor, secondaryColor),
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun weatherThemeColors(@ColorRes primaryColor: Int, @ColorRes secondaryColor: Int) = Colors(
    primary = colorResource(id = primaryColor),
    primaryVariant = colorResource(id = R.color.background_action__emphasis),
    secondary = colorResource(secondaryColor),
    secondaryVariant = colorResource(id = R.color.background__2),
    background = colorResource(id = R.color.background_base),
    surface = colorResource(id = R.color.dialog__background_color),
    error = colorResource(id = R.color.background_negative__default),
    onPrimary = colorResource(id = R.color.fill_light),
    onSecondary = colorResource(id = R.color.fill_action__default),
    onSurface = colorResource(id = R.color.fill_default),
    onError = colorResource(id = R.color.text_inverse),
    onBackground = colorResource(id = R.color.text_default),
    isLight = !isSystemInDarkTheme(),
)


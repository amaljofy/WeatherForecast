package com.gadgeon_mt.weatherforecast.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.compositionLocalOf

val LocalColorsProvider = compositionLocalOf<Colors> { error("not Colors") }
val LocalTypographyProvider = compositionLocalOf<Typography> { error("not Typography") }
val LocalShapesProvider = compositionLocalOf<Shapes> { error("not Shapes") }
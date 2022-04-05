package com.gadgeon_mt.weatherforecast.utils

import androidx.annotation.DimenRes
import androidx.annotation.IntegerRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun dimenToSp(@DimenRes id: Int): TextUnit = dimensionResource(id = id).value.sp

@Composable
fun fontWeight(@IntegerRes id: Int): FontWeight = FontWeight(integerResource(id))

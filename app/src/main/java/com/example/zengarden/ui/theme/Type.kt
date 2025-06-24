package com.example.zengarden.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val fontFamily = FontFamily.Default

data class ZenGardenTypography(
    val title: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 28.sp
    ),
    val body: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp
    ),
    val bodySmall: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.sp
    ),
    val label: TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp
    ),
)

val zenGardenTypography = ZenGardenTypography()
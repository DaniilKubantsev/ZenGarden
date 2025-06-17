package com.example.zengarden.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

data class ColorPalette(
    val surface: Color,
    val background: Color,
    val primary: Color,
    val onPrimary: Color,
    val secondary: Color,
    val onSecondary: Color,
    val accent: Color,
    val onAccent: Color,
    val error: Color,

    val title: Color,
    val body: Color,
    val label: Color,
)

val LightPalette = ColorPalette(
    surface = Parchment,
    background = TeaGreen,
    primary = Olivine,
    onPrimary = onPrimary,
    secondary = DarkOliveGreen,
    onSecondary = White,
    accent = Chamoisee,
    onAccent = Umber,
    error = Error,
    title = DarkGrey,
    body = DarkGrey,
    label = LightGrey
)

val DarkPalette = LightPalette.copy()

val LocalCustomColors = staticCompositionLocalOf { LightPalette }

@Composable
fun ZenGardenTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),

    content: @Composable () -> Unit
) {


    val customColors = if (useDarkTheme) DarkPalette else LightPalette

    CompositionLocalProvider(
        LocalCustomColors provides customColors,

        content = content
    )
}

object ZenGardenTheme {
    val colors: ColorPalette
        @Composable @ReadOnlyComposable
        get() = LocalCustomColors.current
}
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


val LocalCustomColors = staticCompositionLocalOf { lightZenGardenColorScheme }
val LocalCustomTypography = staticCompositionLocalOf { zenGardenTypography }

@Composable
fun ZenGardenTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val customColors = if (useDarkTheme) darkZenGardenColorScheme else lightZenGardenColorScheme

    CompositionLocalProvider(
        LocalCustomColors provides customColors,
        LocalCustomTypography provides zenGardenTypography,
        content = content
    )
}

object ZenGardenTheme {
    val colors: ZenGardenColorScheme
        @Composable @ReadOnlyComposable
        get() = LocalCustomColors.current

    val typography: ZenGardenTypography
        @Composable @ReadOnlyComposable
        get() = LocalCustomTypography.current
}
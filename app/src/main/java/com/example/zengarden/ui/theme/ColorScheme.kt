package com.example.zengarden.ui.theme

import androidx.compose.ui.graphics.Color

data class ZenGardenColorScheme(
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

val lightZenGardenColorScheme = ZenGardenColorScheme(
    surface = Parchment,
    background = TeaGreen,
    primary = Olivine,
    onPrimary = DarkOliveGreen,
    secondary = DarkOliveGreen,
    onSecondary = White,
    accent = Chamoisee,
    onAccent = Umber,
    error = Error,
    title = DarkGrey,
    body = DarkGrey,
    label = LightGrey
)

val darkZenGardenColorScheme = lightZenGardenColorScheme.copy()

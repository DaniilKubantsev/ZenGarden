package com.example.zengarden.ui.theme

import android.health.connect.datatypes.units.Temperature
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

    val tretiary: Color,
    val onTretiary: Color,

    val watering: Color,
    val onWatering: Color,
    val lightLevel: Color,
    val onLightLevel: Color,
    val temperature: Color,
    val onTemperature: Color,

)

val lightZenGardenColorScheme = ZenGardenColorScheme(
    surface = Parchment,
    background = TeaGreen,
    primary = Olivine,
    onPrimary = DarkOliveGreen,
    secondary = Secondary,
    onSecondary = White,
    accent = Chamoisee,
    onAccent = Umber,
    error = Error,

    tretiary = Tretiary,
    onTretiary = OnTretiary,

    watering = Waterign,
    onWatering = OnWatering,
    lightLevel = LightLevel,
    onLightLevel = OnLightLevel,
    temperature = Temp,
    onTemperature = OnTemp,
)

val darkZenGardenColorScheme = lightZenGardenColorScheme.copy()

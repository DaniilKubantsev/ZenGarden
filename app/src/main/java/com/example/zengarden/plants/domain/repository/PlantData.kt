package com.example.zengarden.plants.domain.repository

data class PlantData(
    val name: String = "",
    val wateringIntensity: String = "",
    val lightLevel: String = "",
    val temperatureRange: Pair<Int, Int> = Pair(0, 0),
    val comment: String = "",
    val id: Int = 0,
)

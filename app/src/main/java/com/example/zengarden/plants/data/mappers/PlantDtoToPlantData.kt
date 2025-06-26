package com.example.zengarden.plants.data.mappers

import com.example.zengarden.plants.data.remote.PlantResponseDto
import com.example.zengarden.plants.domain.repository.PlantData

fun PlantResponseDto.toPlantData(): PlantData {
    return PlantData(
        name = this.name,
        wateringIntensity = this.wateringIntensity ?: "medium",
        lightLevel = this.lightLevel ?: "Diffused light",
        temperatureRange = Pair(this.temperatureRange?.min?.toInt() ?: 0, this.temperatureRange?.max?.toInt() ?: 0),
        comment = this.comment?: "",
        id = this.id,
    )
}
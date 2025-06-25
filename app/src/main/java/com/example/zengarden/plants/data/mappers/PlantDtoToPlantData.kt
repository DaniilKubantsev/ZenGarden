package com.example.zengarden.plants.data.mappers

import com.example.zengarden.plants.data.remote.PlantResponseDto
import com.example.zengarden.plants.domain.repository.PlantData

fun PlantResponseDto.toPlantData(): PlantData {
    return PlantData(
        name = this.name,
        wateringIntensity = this.wateringIntensity,
        lightLevel = this.lightLevel,
        temperatureRange = Pair(this.temperatureRange.min, this.temperatureRange.max),
        comment = this.comment,
        id = this.id,
    )
}
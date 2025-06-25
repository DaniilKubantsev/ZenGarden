package com.example.zengarden.plants.data.remote

import com.google.gson.annotations.SerializedName

data class PlantResponseDto(
    @SerializedName("name") val name: String,
    @SerializedName("watering_intensity") val wateringIntensity: String,
    @SerializedName("light_level") val lightLevel: String,
    @SerializedName("temperature_range") val temperatureRange: TemperatureRange,
    @SerializedName("comment") val comment: String = "",
    @SerializedName("id") val id: Int,
    @SerializedName("owner_id") val ownerId: Int,
)

data class TemperatureRange(
    @SerializedName("min") val min: Int = 0,
    @SerializedName("max") val max: Int = 0,
)
package com.example.zengarden.plants.data.remote

import com.google.gson.annotations.SerializedName

data class CreatePlantRequestDto(
    @SerializedName("name") val name: String,
    @SerializedName("watering_intensity") val wateringIntensity: String?,
    @SerializedName("light_level") val lightLevel: String?,
    @SerializedName("temperature_range") val temperatureRange: TemperatureRange?,
    @SerializedName("comment") val comment: String?,
)


package com.example.zengarden.plants.presentation

import com.example.zengarden.plants.domain.repository.PlantData
import java.lang.Error

sealed interface PlantsState {
    data object Loading : PlantsState

    data class Main(
        val plantsData: List<PlantData> = listOf(),
        val error: String? = null
    ) : PlantsState

    data class CreatePlant(
        val name: String = "Sebastian",
        val wateringIntensity: String = "Light",
        val lightLevel: String = "Shadow",
        val minTemp: Int = 15,
        val maxTemp: Int = 20,
        val comment: String = "LOremaldskughaoidfnnvosadgruihsdfkjvnsldfhguiwehrovijzndociugyhseoruivnskldjfhgoiuwerntvjoshdfuighsopiretg",
        val error: String? = null
    ) : PlantsState

    data class EditPlant(
        val name: String = "Sebastian",
        val wateringIntensity: String = "Light",
        val lightLevel: String = "Shadow",
        val minTemp: Int = 15,
        val maxTemp: Int = 20,
        val comment: String = "LOremaldskughaoidfnnvosadgruihsdfkjvnsldfhguiwehrovijzndociugyhseoruivnskldjfhgoiuwerntvjoshdfuighsopiretg",
        val error: String? = null
    ) : PlantsState
}
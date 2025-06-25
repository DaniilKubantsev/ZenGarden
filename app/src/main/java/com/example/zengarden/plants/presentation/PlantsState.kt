package com.example.zengarden.plants.presentation

import com.example.zengarden.plants.domain.repository.PlantData
import java.lang.Error

sealed interface PlantsState {
    data object Loading : PlantsState

    data class Main(
        val plantsData: List<PlantData> = listOf(),
        val error: String? = null
    ) : PlantsState
}
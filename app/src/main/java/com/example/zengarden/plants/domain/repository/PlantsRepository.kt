package com.example.zengarden.plants.domain.repository

import com.example.zengarden.core.utils.Resource

interface PlantsRepository {
    suspend fun loadPlantData(): Resource<List<PlantData>>
    suspend fun deletePlantData(plantId: Int): Resource<String>
    suspend fun createPlantData(plantData: PlantData): Resource<PlantData>
}
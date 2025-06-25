package com.example.zengarden.plants.domain.repository

import com.example.zengarden.core.utils.Resource

interface PlantsRepository {
    suspend fun loadPlantData(): Resource<List<PlantData>>
}
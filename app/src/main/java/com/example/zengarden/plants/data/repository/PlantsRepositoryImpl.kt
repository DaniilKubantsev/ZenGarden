package com.example.zengarden.plants.data.repository

import com.example.zengarden.core.utils.Resource
import com.example.zengarden.plants.data.mappers.toPlantData
import com.example.zengarden.plants.data.remote.PlantsApi
import com.example.zengarden.plants.domain.repository.PlantData
import com.example.zengarden.plants.domain.repository.PlantsRepository

class PlantsRepositoryImpl(
    private val plantsApi: PlantsApi
): PlantsRepository {
    override suspend fun loadPlantData(): Resource<List<PlantData>> {
        return try {
            val response = plantsApi.getPlants()

            if (response.isSuccessful) {
                Resource.Success(
                    data = response.body()!!.map {
                        it.toPlantData()
                    }
                )
            } else {
                Resource.Error(message = "Server error. Code ${response.code()}")
            }

        } catch (e: Exception) {
            Resource.Error(message = "Network error: ${e.message}")
        }

    }
}
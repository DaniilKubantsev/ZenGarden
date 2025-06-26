package com.example.zengarden.plants.data.repository

import android.util.Log
import com.example.zengarden.core.utils.Resource
import com.example.zengarden.plants.data.mappers.toPlantData
import com.example.zengarden.plants.data.remote.CreatePlantRequestDto
import com.example.zengarden.plants.data.remote.PlantsApi
import com.example.zengarden.plants.data.remote.TemperatureRange
import com.example.zengarden.plants.domain.repository.PlantData
import com.example.zengarden.plants.domain.repository.PlantsRepository
import retrofit2.HttpException
import kotlin.math.max

class PlantsRepositoryImpl(
    private val plantsApi: PlantsApi
): PlantsRepository {
    override suspend fun loadPlantData(): Resource<List<PlantData>> {
        return try {
            val response = plantsApi.getPlants()

            if (response.isSuccessful) {
                val plantsDataList = response.body()?.map {
                    it.toPlantData()
                }

                Resource.Success(
                    data = plantsDataList
                )

            } else {
                Resource.Error(
                    message = "Server error. ${response.errorBody()}",
                    data = null
                )
                throw UnauthorizedException(message = response.message(), code = response.code())
            }
        } catch (e: HttpException) {
            when (e.code()) {
                401 -> { throw UnauthorizedException(message = e.message(), code = e.code()) }
                else -> {}
            }
            Resource.Error(message = "Network error: ${e.message}")
        }
    }

    override suspend fun deletePlantData(plantId: Int): Resource<String> {
        return try {
            val response = plantsApi.deletePlant(plantId.toString())
            if (response.isSuccessful) {
                Resource.Success(data = response.body())
            } else {
                Resource.Error(message = response.message())
            }
        } catch (e: HttpException) {
            when (e.code()) {
                401 -> { throw UnauthorizedException(message = e.message(), code = e.code()) }
                else -> {}
            }
            Resource.Error(message = "Network error: ${e.message}")
        }
    }

    override suspend fun createPlantData(plandData: PlantData): Resource<PlantData> {
        return try {
            val requestDto = CreatePlantRequestDto(
                name = plandData.name,
                wateringIntensity = plandData.wateringIntensity,
                lightLevel = plandData.lightLevel,
                temperatureRange = TemperatureRange(
                    min = plandData.temperatureRange.first.toFloat(),
                    max = plandData.temperatureRange.second.toFloat()
                ),
                comment = plandData.comment
            )

            Log.w("aasdfasdf", "$requestDto")

            val response = plantsApi.createPlant(
                requestDto = requestDto
            )

            if (response.isSuccessful) {
                Resource.Success(data = response.body()?.toPlantData())
            } else {
                Resource.Error(message = response.message())
            }
        } catch (e: HttpException) {
            when (e.code()) {
                401 -> { throw UnauthorizedException(message = e.message(), code = e.code()) }
                else -> {}
            }
            Resource.Error(message = "Network error: ${e.message}")
        }
    }
}
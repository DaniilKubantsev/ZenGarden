package com.example.zengarden.plants.data.remote

import com.example.zengarden.auth.data.remote.AuthApi
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PlantsApi {

    @GET("/api/v1/flowers/")
    suspend fun getPlants(): Response<List<PlantResponseDto>>

    @POST("/api/v1/flowers/")
    suspend fun createPlant(@Body requestDto: CreatePlantRequestDto): Response<PlantResponseDto>

//    @PUT("/api/v1/flowers/{flower_id}")
//    suspend fun updatePlant(
//        @Path("flower_id") plantId: String
//    )
//
    @DELETE("/api/v1/flowers/{flower_id}")
    suspend fun deletePlant(
        @Path("flower_id") plantId: String
    ): Response<String>
}

fun createPlantsApi(retrofit: Retrofit): PlantsApi = retrofit.create(PlantsApi::class.java)
package com.example.zengarden.plants.presentation

sealed interface PlantsEvent {
    data object LoadPlants : PlantsEvent
}
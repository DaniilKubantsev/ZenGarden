package com.example.zengarden.plants.presentation

sealed interface PlantsEffect{
    data object NavigateToAuth : PlantsEffect
}
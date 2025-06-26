package com.example.zengarden.plants.presentation

sealed interface PlantsEvent {
    data object LoadPlants : PlantsEvent

    data class DeletePlant(val id: Int) : PlantsEvent

    data object CreatePlant : PlantsEvent
    data object SubmitCreation : PlantsEvent
    data object CancelCreation : PlantsEvent

    data class OnNameChange(val value: String) : PlantsEvent
    data class OnWateringIntensityChange(val value: String) : PlantsEvent
    data class OnLightLevelChange(val value: String) : PlantsEvent
    data class OnMinTempChange(val value: String) : PlantsEvent
    data class OnMaxTempChange(val value: String) : PlantsEvent
    data class OnCommentChange(val value: String) : PlantsEvent
}
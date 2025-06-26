package com.example.zengarden.plants.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.zengarden.auth.presentation.AuthEffect
import com.example.zengarden.auth.presentation.AuthState
import com.example.zengarden.core.network.TokenManager
import com.example.zengarden.core.utils.Resource
import com.example.zengarden.plants.data.repository.UnauthorizedException
import com.example.zengarden.plants.domain.repository.PlantData
import com.example.zengarden.plants.domain.repository.PlantsRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class PlantsViewModel(
    private val plantsRepository: PlantsRepository,
    private val jwtManager: TokenManager,
) : ViewModel() {
    private val _state = MutableStateFlow<PlantsState>(PlantsState.Loading)
    val state = _state.asStateFlow()


    private val _effect = Channel<PlantsEffect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()


    init {
        loadPlants()
    }


    fun onEvent(event: PlantsEvent) = when (event) {
        is PlantsEvent.LoadPlants -> {
            loadPlants()
        }

        is PlantsEvent.DeletePlant -> {
            deletePlant(event.id)
        }

        is PlantsEvent.CreatePlant -> {
            createPlant()
        }

        is PlantsEvent.SubmitCreation -> {
            submitCreation()
        }

        is PlantsEvent.CancelCreation -> {
            toMainState()
        }

        is PlantsEvent.OnCommentChange -> {
            _state.value = (_state.value as PlantsState.CreatePlant).copy(comment = event.value)
        }

        is PlantsEvent.OnLightLevelChange -> {
            _state.value = (_state.value as PlantsState.CreatePlant).copy(lightLevel = event.value)
        }

        is PlantsEvent.OnMaxTempChange -> {
            _state.value = (_state.value as PlantsState.CreatePlant)
                .copy(
                    maxTemp = event.value
                )
        }

        is PlantsEvent.OnMinTempChange -> {
            _state.value = (_state.value as PlantsState.CreatePlant)
                .copy(
                    minTemp = event.value
                )
        }

        is PlantsEvent.OnNameChange -> {
            _state.value = (_state.value as PlantsState.CreatePlant).copy(name = event.value)
        }

        is PlantsEvent.OnWateringIntensityChange -> {
            _state.value =
                (_state.value as PlantsState.CreatePlant).copy(wateringIntensity = event.value)
        }

    }

    private fun toMainState() {
        loadPlants()
    }

    private fun invalidCreation(createState: PlantsState.CreatePlant): Boolean {
        return createState.name == ""
                && createState.wateringIntensity == ""
                && createState.lightLevel == ""
                && createState.minTemp == ""
                && createState.maxTemp == ""
    }

    private fun submitCreation() {
        val currentState = _state.value as PlantsState.CreatePlant

        if (invalidCreation(currentState)) {
            _state.value = (_state.value as PlantsState.CreatePlant).copy(
                error = "Empty fields!"
            )
        } else {
            viewModelScope.launch {
                try {
                    when (val result = plantsRepository.createPlantData(
                        plantData = PlantData(
                            name = currentState.name,
                            wateringIntensity = currentState.wateringIntensity,
                            lightLevel = currentState.lightLevel,
                            temperatureRange = Pair(
                                currentState.minTemp.toInt(),
                                currentState.maxTemp.toInt()
                            ),
                            comment = currentState.comment
                        )
                    )) {
                        is Resource.Success -> {

                        }

                        is Resource.Error -> {
                            Log.w("RESOURCE.ERROR", "${result.message}")
                            _state.value = PlantsState.Main(
                                error = result.message
                            )
                        }
                    }

                } catch (e: Exception) {
                    Log.w("ERROR", "${e.message}")
                    if (e is UnauthorizedException) {
                        jwtManager.clearToken()
                        _effect.send(PlantsEffect.NavigateToAuth)
                    }
                }
            }
            loadPlants()
        }


    }

    private fun createPlant() {
        _state.value = PlantsState.CreatePlant()
    }


    private fun deletePlant(plantId: Int) {
        viewModelScope.launch {
            try {
                when (val result = plantsRepository.deletePlantData(plantId)) {
                    is Resource.Success -> {

                    }

                    is Resource.Error -> {
                        Log.w("RESOURCE.ERROR", "${result.message}")
                        _state.value = PlantsState.Main(
                            error = result.message
                        )
                    }
                }

            } catch (e: Exception) {
                if (e is UnauthorizedException) {
                    jwtManager.clearToken()
                    _effect.send(PlantsEffect.NavigateToAuth)
                }
            }
            loadPlants()
        }

    }


    private fun loadPlants() {

        viewModelScope.launch {
            try {
                when (val result = plantsRepository.loadPlantData()) {
                    is Resource.Success -> {
                        if (result.data!!.isEmpty()) {
                            _state.value = PlantsState.Main()
                        } else {
                            _state.value = PlantsState.Main(plantsData = result.data)
                        }
                    }

                    is Resource.Error -> {
                        Log.w("RESOURCE.ERROR", "${result.message}")
                        _state.value = PlantsState.Main(
                            error = result.message
                        )
                    }
                }

            } catch (e: Exception) {
                if (e is UnauthorizedException) {
                    jwtManager.clearToken()
                    _effect.send(PlantsEffect.NavigateToAuth)
                }
            }
        }
    }
}
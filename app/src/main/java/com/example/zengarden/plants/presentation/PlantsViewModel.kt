package com.example.zengarden.plants.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zengarden.auth.presentation.AuthState
import com.example.zengarden.core.utils.Resource
import com.example.zengarden.plants.domain.repository.PlantsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PlantsViewModel(
    private val plantsRepository: PlantsRepository
) : ViewModel() {
    private val _state = MutableStateFlow<PlantsState>(PlantsState.Loading)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val result = plantsRepository.loadPlantData()

            Log.w("PLANTS_VIEWMODEL", "REQUEST SUCCESS")

            when (result) {
                is Resource.Success -> {
                    Log.w("PLANTS_VIEWMODEL", "PLANTS_DATA ${(_state.value as PlantsState.Main).plantsData}")
                    _state.value = PlantsState.Main(
                        plantsData = result.data!!
                    )

                }
                is Resource.Error -> {
                    Log.w("PLANTS_VIEWMODEL", "ERROR ${result.message}")
                    _state.value = PlantsState.Main(
                        error = result.message
                    )
                }
            }
        }
    }
}
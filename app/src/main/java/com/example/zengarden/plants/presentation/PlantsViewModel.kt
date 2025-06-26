package com.example.zengarden.plants.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zengarden.auth.presentation.AuthEffect
import com.example.zengarden.auth.presentation.AuthState
import com.example.zengarden.core.network.TokenManager
import com.example.zengarden.core.utils.Resource
import com.example.zengarden.plants.data.repository.UnauthorizedException
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
        viewModelScope.launch {
            try {
                val result = plantsRepository.loadPlantData()
                when (result) {
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
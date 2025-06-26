package com.example.zengarden.plants.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.zengarden.auth.presentation.AuthEffect
import com.example.zengarden.plants.presentation.composable.PlantCreateView
import com.example.zengarden.plants.presentation.composable.PlantView
import com.example.zengarden.ui.theme.ZenGardenTheme

@Composable
fun PlantsScreen(
    viewModel: PlantsViewModel,
    paddingValues: PaddingValues,
    onUnauth: () -> Unit,
    modifier: Modifier,
) {
    val state = viewModel.state.collectAsState()


    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        when (state.value) {
            is PlantsState.Main -> {
                MainPlantState(
                    state = state.value as PlantsState.Main,
                    onEvent = viewModel::onEvent,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .then(modifier)
                )
            }
            is PlantsState.CreatePlant -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(paddingValues)
                        .then(modifier)
                ) {
                    PlantCreateView(
                        state = state.value as PlantsState.CreatePlant,
                        onEvent = viewModel::onEvent,
                        shape = RoundedCornerShape(31.dp),
                        backgroundColor = ZenGardenTheme.colors.secondary,
                        modifier = Modifier
                            .padding(10.dp)
                            .background(
                                color = ZenGardenTheme.colors.primary,
                                shape = RoundedCornerShape(31.dp)
                            )

                    )
                }
            }
            is PlantsState.EditPlant -> {

            }
            is PlantsState.Loading -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .background(ZenGardenTheme.colors.surface)
                        .fillMaxSize()
                ) {
                    CircularProgressIndicator(
                        color = ZenGardenTheme.colors.onAccent,
                        modifier = Modifier.size(200.dp)
                    )
                }

            }
        }
    }




    LaunchedEffect(key1 = viewModel) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is PlantsEffect.NavigateToAuth -> {
                    onUnauth()
                }
            }
        }
    }

}
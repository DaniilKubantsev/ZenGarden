package com.example.zengarden.plants.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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




    when (state.value) {
        is PlantsState.Main -> {
            LazyColumn (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = PaddingValues(5.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .then(modifier)
            ) {
                items((state.value as PlantsState.Main).plantsData) { plantData ->
                    PlantView(
                        plantData = plantData,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = ZenGardenTheme.colors.secondary,
                                shape = RoundedCornerShape(31.dp)
                            )
                            .padding(10.dp)
                    )
                }
            }
        }
        is PlantsState.CreatePlant -> {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(paddingValues)
                    .then(modifier)
            ) {
                PlantCreateView(
                    title = "Create",
                    state = state.value as PlantsState.CreatePlant,
                    onSubmit = {},
                    onEvent = {},
                    shape = RoundedCornerShape(31.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .background(
                            color = ZenGardenTheme.colors.secondary,
                            shape = RoundedCornerShape(31.dp)
                        )
                        .padding(10.dp)
                )
            }
        }
        is PlantsState.EditPlant -> {

        }
        is PlantsState.Loading -> {
            CircularProgressIndicator()
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
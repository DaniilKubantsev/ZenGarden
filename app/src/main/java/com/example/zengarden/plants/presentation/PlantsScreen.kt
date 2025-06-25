package com.example.zengarden.plants.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun PlantsScreen(
    viewModel: PlantsViewModel,
    paddingValues: PaddingValues,
    modifier: Modifier,
) {
    val state = viewModel.state.collectAsState()

    when (state.value) {
        is PlantsState.Main -> {
            LazyColumn (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(paddingValues)
                    .then(modifier)
            ) {
                items((state.value as PlantsState.Main).plantsData) { plantData ->
                    Text(
                        text = plantData.toString()
                    )
                }
            }
        }
        is PlantsState.Loading -> {
            CircularProgressIndicator()
        }
    }




}
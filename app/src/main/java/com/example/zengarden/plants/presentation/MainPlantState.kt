package com.example.zengarden.plants.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.zengarden.plants.presentation.composable.PlantView
import com.example.zengarden.ui.theme.ZenGardenTheme

@Composable
fun MainPlantState (
    state: PlantsState.Main,
    onEvent: (PlantsEvent) -> Unit,
    modifier: Modifier,
) {
    LazyColumn (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(horizontal = 5.dp, vertical = 10.dp),
        modifier = modifier
    ) {
        item {
            Text(
                text = "\uD83D\uDCBE Update",
                style = ZenGardenTheme.typography.title,
                color = ZenGardenTheme.colors.onAccent,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onEvent(PlantsEvent.LoadPlants)
                    }
            )
        }
        item {
            Text(
                text = "\uD83E\uDEB4 Create",
                style = ZenGardenTheme.typography.title,
                color = ZenGardenTheme.colors.onAccent,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onEvent(PlantsEvent.CreatePlant)
                    }
            )
        }
        items(state.plantsData) { plantData ->
            PlantView(
                plantData = plantData,
                onDelete = { onEvent(PlantsEvent.DeletePlant(it)) },
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
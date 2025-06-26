package com.example.zengarden.plants.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zengarden.R
import com.example.zengarden.auth.presentation.composables.ActionButton
import com.example.zengarden.plants.presentation.PlantsEvent
import com.example.zengarden.plants.presentation.PlantsState
import com.example.zengarden.plants.presentation.composable.settings.LightLevelSettingView
import com.example.zengarden.plants.presentation.composable.settings.NameSettingView
import com.example.zengarden.plants.presentation.composable.settings.NoteSettingView
import com.example.zengarden.plants.presentation.composable.settings.TemperatureSettingView
import com.example.zengarden.plants.presentation.composable.settings.WateringSettingView
import com.example.zengarden.ui.theme.ZenGardenTheme

@Composable
fun PlantCreateView(
    title: String,
    state: PlantsState.CreatePlant,
    onEvent: (PlantsEvent) -> Unit,
    onSubmit: (PlantsEvent) -> Unit,
    shape: Shape = RoundedCornerShape(20.dp),
    modifier: Modifier = Modifier
) {

    val lightLevelOptions = stringArrayResource(R.array.light_options).toList()
    val wateringOptions = stringArrayResource(R.array.watering_options).toList()

    
    Column(
        modifier = Modifier
            .background(
                color = ZenGardenTheme.colors.primary,
                shape = shape
            )
            .clip(shape)
    ) {
        Text(
            text = title,
            style = ZenGardenTheme.typography.title,
            color = ZenGardenTheme.colors.onPrimary,
            modifier = Modifier
                .padding(15.dp)
        )

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier
        ) {

            NameSettingView(
                value = state.name,
                onValueChange = { onEvent(PlantsEvent.OnNameChange(it)) },
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(Modifier.height(10.dp))

            WateringSettingView(
                value = state.wateringIntensity,
                onClick = { onEvent(PlantsEvent.OnWateringIntensityChange(it)) },
                options = wateringOptions,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(Modifier.height(10.dp))

            LightLevelSettingView(
                value = state.lightLevel,
                options = lightLevelOptions,
                onClick = { onEvent(PlantsEvent.OnWateringIntensityChange(it)) },
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(Modifier.height(10.dp))

            TemperatureSettingView(
                minTempValue = state.minTemp.toString(),
                onMinValueChange = { onEvent(PlantsEvent.OnMinTempChange(it)) },
                maxTempValue = state.maxTemp.toString(),
                onMaxValueChange = { onEvent(PlantsEvent.OnMaxTempChange(it)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = ZenGardenTheme.colors.tretiary,
                        shape = CircleShape
                    )
                    .padding(5.dp)
            )

            Spacer(Modifier.height(10.dp))

            NoteSettingView(
                value = state.comment,
                onValueChange = { onEvent(PlantsEvent.OnCommentChange(it)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = ZenGardenTheme.colors.tretiary,
                        shape = RoundedCornerShape(23.dp)
                    )
                    .padding(5.dp)
            )

            Spacer(Modifier.height(10.dp))

            ActionButton(
                onClick = { onSubmit(PlantsEvent.OnMaxTempChange("")) },
                text = "Submit",
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}



@Composable
fun PlantEditView(
    title: String,
    state: PlantsState.EditPlant,
    onEvent: (PlantsEvent) -> Unit,
    onSubmit: (PlantsEvent) -> Unit,
    shape: Shape = RoundedCornerShape(20.dp),
    modifier: Modifier = Modifier
) {

    val lightLevelOptions = stringArrayResource(R.array.light_options).toList()
    val wateringOptions = stringArrayResource(R.array.watering_options).toList()


    Column(
        modifier = Modifier
            .background(
                color = ZenGardenTheme.colors.primary,
                shape = shape
            )
            .clip(shape)
    ) {
        Text(
            text = title,
            style = ZenGardenTheme.typography.title,
            color = ZenGardenTheme.colors.onPrimary,
            modifier = Modifier
                .padding(15.dp)
        )

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier
        ) {

            NameSettingView(
                value = state.name,
                onValueChange = { onEvent(PlantsEvent.OnNameChange(it)) },
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(Modifier.height(10.dp))

            WateringSettingView(
                value = state.wateringIntensity,
                onClick = { onEvent(PlantsEvent.OnWateringIntensityChange(it)) },
                options = wateringOptions,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(Modifier.height(10.dp))

            LightLevelSettingView(
                value = state.lightLevel,
                options = lightLevelOptions,
                onClick = { onEvent(PlantsEvent.OnWateringIntensityChange(it)) },
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(Modifier.height(10.dp))

            TemperatureSettingView(
                minTempValue = state.minTemp.toString(),
                onMinValueChange = { onEvent(PlantsEvent.OnMinTempChange(it)) },
                maxTempValue = state.maxTemp.toString(),
                onMaxValueChange = { onEvent(PlantsEvent.OnMaxTempChange(it)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = ZenGardenTheme.colors.tretiary,
                        shape = CircleShape
                    )
                    .padding(5.dp)
            )

            Spacer(Modifier.height(10.dp))

            NoteSettingView(
                value = state.comment,
                onValueChange = { onEvent(PlantsEvent.OnCommentChange(it)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = ZenGardenTheme.colors.tretiary,
                        shape = RoundedCornerShape(23.dp)
                    )
                    .padding(5.dp)
            )

            Spacer(Modifier.height(10.dp))

            ActionButton(
                onClick = { onSubmit(PlantsEvent.OnMaxTempChange("")) },
                text = "Submit",
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }


}




@Preview(showBackground = true)
@Composable
fun AddPlantViewPreview() {
    ZenGardenTheme {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = ZenGardenTheme.colors.surface
                )
        ) {
            PlantCreateView(
                title = "Create",
                state = PlantsState.CreatePlant(),
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
}
package com.example.zengarden.plants.presentation.composable

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
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
    state: PlantsState.CreatePlant,
    onEvent: (PlantsEvent) -> Unit,
    backgroundColor: Color,
    shape: Shape = RoundedCornerShape(20.dp),
    paddingValues: PaddingValues = PaddingValues(10.dp),
    modifier: Modifier = Modifier
) {

    val lightLevelOptions = stringArrayResource(R.array.light_options).toList()
    val wateringOptions = stringArrayResource(R.array.watering_options).toList()


    Column(
        modifier = modifier

    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Text(
                text = "Create",
                style = ZenGardenTheme.typography.title,
                color = ZenGardenTheme.colors.onPrimary,
                modifier = Modifier
                    .padding(15.dp)
            )

            Text(
                text = "❌",
                style = ZenGardenTheme.typography.title,
                modifier = Modifier
                    .padding(15.dp)
                    .clickable {
                        onEvent(PlantsEvent.CancelCreation)
                    }
            )
        }


        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    backgroundColor,
                    shape
                )
                .padding(paddingValues)
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
                onClick = { onEvent(PlantsEvent.OnLightLevelChange(it)) },
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(Modifier.height(10.dp))

            TemperatureSettingView(
                minTempValue = state.minTemp,
                onMinValueChange = { onEvent(PlantsEvent.OnMinTempChange(it)) },
                maxTempValue = state.maxTemp,
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

            if(state.error != null) {
                Text(
                    text = state.error,
                    color = ZenGardenTheme.colors.error,
                    style = ZenGardenTheme.typography.bodySmall,
                    modifier = Modifier
                        .padding(start = 20.dp)
                )
            }

            ActionButton(
                onClick = {
                    onEvent(PlantsEvent.SubmitCreation)
                },

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
                state = PlantsState.CreatePlant(),
                onEvent = {},
                shape = RoundedCornerShape(31.dp),
                backgroundColor = ZenGardenTheme.colors.secondary,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .background(
                        color = ZenGardenTheme.colors.primary,
                        shape = RoundedCornerShape(31.dp)
                    )

            )
        }
    }
}
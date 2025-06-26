package com.example.zengarden.plants.presentation.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zengarden.R
import com.example.zengarden.auth.presentation.composables.ActionButton
import com.example.zengarden.auth.presentation.composables.ActionButtonPreview
import com.example.zengarden.plants.domain.repository.PlantData
import com.example.zengarden.plants.presentation.composable.components.PlantDataFeatureView
import com.example.zengarden.ui.theme.ZenGardenTheme

@Composable
fun PlantView(
    plantData: PlantData,
    modifier: Modifier,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {

        PlantDataFeatureView(
            value = plantData.name,
            label = {
                Text(
                    text = "\uD83C\uDF3F Name" + " ",
                    style = ZenGardenTheme.typography.label,
                    color = ZenGardenTheme.colors.onPrimary,
                    modifier = Modifier
                        .background(
                            color = ZenGardenTheme.colors.primary,
                            shape = CircleShape
                        )
                        .padding(10.dp, 5.dp)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = ZenGardenTheme.colors.tretiary,
                    shape = CircleShape
                )
                .padding(5.dp)
        )

        Spacer(Modifier.height(10.dp))

        PlantDataFeatureView(
            value = plantData.wateringIntensity,
            label = {
                Text(
                    text = stringResource(R.string.watering_level) + " ",
                    style = ZenGardenTheme.typography.label,
                    color = ZenGardenTheme.colors.onWatering,
                    modifier = Modifier

                        .background(
                            color = ZenGardenTheme.colors.watering,
                            shape = CircleShape
                        )
                        .padding(10.dp, 5.dp)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = ZenGardenTheme.colors.tretiary,
                    shape = CircleShape
                )
                .padding(5.dp)
        )

        Spacer(Modifier.height(10.dp))

        PlantDataFeatureView(
            value = plantData.lightLevel,
            label = {
                Text(
                    text = stringResource(R.string.light_level) + " ",
                    style = ZenGardenTheme.typography.label,
                    color = ZenGardenTheme.colors.onLightLevel,
                    modifier = Modifier

                        .background(
                            color = ZenGardenTheme.colors.lightLevel,
                            shape = CircleShape
                        )
                        .padding(10.dp, 5.dp)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = ZenGardenTheme.colors.tretiary,
                    shape = CircleShape
                )
                .padding(5.dp)
        )

        Spacer(Modifier.height(10.dp))

        PlantDataFeatureView(
            value = "From ${plantData.temperatureRange.first} to ${plantData.temperatureRange.second} °C",
            label = {
                Text(
                    text = "\uD83C\uDF21\uFE0F Temp" + " ",
                    style = ZenGardenTheme.typography.label,
                    color = ZenGardenTheme.colors.onTemperature,
                    modifier = Modifier

                        .background(
                            color = ZenGardenTheme.colors.temperature,
                            shape = CircleShape
                        )
                        .padding(10.dp, 5.dp)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = ZenGardenTheme.colors.tretiary,
                    shape = CircleShape
                )
                .padding(5.dp)
        )

        Spacer(Modifier.height(10.dp))

        PlantNoteView(
            value = plantData.comment,
            label = {
                Text(
                    text = "✏\uFE0F Note" + " ",
                    style = ZenGardenTheme.typography.label,
                    color = ZenGardenTheme.colors.onTretiary,
                    modifier = Modifier

                        .background(
                            color = Color.Gray,
                            shape = CircleShape
                        )
                        .padding(10.dp, 5.dp)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = ZenGardenTheme.colors.tretiary,
                    shape = RoundedCornerShape(25.dp)
                )
                .padding(5.dp)
        )

        Spacer(Modifier.height(10.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ActionButton(
                onClick = {},
                text = "Edit",
                modifier = Modifier
                    .fillMaxWidth(0.5f)
            )

            Spacer(Modifier.width(10.dp))

            ActionButton(
                onClick = {},
                text = "Delete",
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
@Preview
fun PlantViewPreview() {
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
            PlantView(
                plantData = PlantData(
                    name = "Sebastian",
                    wateringIntensity = "Medium",
                    lightLevel = "Diffused light",
                    comment = "laskjhdfglusdnfvjnsldrhglksjdhfglkjsdhfgksheurg"
                ),
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

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
fun PlantNoteView(
    value: String,
    label: @Composable () -> Unit,
    modifier: Modifier,
) {

    Column(
        modifier = modifier
    ) {
        label()

        Spacer(Modifier.width(5.dp))
        if (value.isNotEmpty()) {
            Text(
                text = value,
                color = ZenGardenTheme.colors.onTretiary,
                style = ZenGardenTheme.typography.body,
                modifier = Modifier
                    .padding(10.dp)
            )
        }

    }
}
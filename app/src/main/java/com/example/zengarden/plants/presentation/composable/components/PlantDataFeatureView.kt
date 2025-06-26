package com.example.zengarden.plants.presentation.composable.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zengarden.ui.theme.ZenGardenTheme

@Composable
fun PlantDataFeatureView(
    value: String,
    label: @Composable () -> Unit,
    modifier: Modifier,
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        label()

        Spacer(Modifier.width(5.dp))
        Text(
            text = value,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            color = ZenGardenTheme.colors.onTretiary,
            style = ZenGardenTheme.typography.body
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PlantNamePreview() {
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
            PlantDataFeatureView(
                value = "sebastian",
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
        }
    }
}
package com.example.zengarden.plants.presentation.composable.components

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.example.zengarden.ui.theme.ZenGardenTheme

@Composable
fun DropDownTextField(
    currentOption: String,
    options: List<String>,
    onClick: (String) -> Unit,
    textColor: Color = Color.Black,
    backgroundColor: Color = Color.White,
    shape: Shape = RoundedCornerShape(10.dp),
    paddingValues: PaddingValues,
    menuTextColor: Color = Color.Black,
    menuBackgroundColor: Color = Color.White,
    style: TextStyle,
    modifier: Modifier = Modifier,
    label: @Composable () -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = shape
            )
            .padding(paddingValues)
            .clickable {
                expanded = !expanded
            }
    ) {

        label()

        Spacer(Modifier.width(5.dp))
        Text(
            text = currentOption,
            style = style,
            color = textColor,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier
                .padding(horizontal = 5.dp)
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            containerColor = menuBackgroundColor,
            properties = PopupProperties(
                clippingEnabled = true
            ),
            shape = RoundedCornerShape(20.dp)

        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = option,
                            style = style,
                            color = menuTextColor
                        )
                    },
                    onClick = {
                        onClick(option)
                        expanded = false
                    },
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DropDownTextFieldPreview() {
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
            var currentOption by remember { mutableStateOf("Интенсивный") }
            val options = listOf("Редкий", "Умеренный", "Интенсивный")

            DropDownTextField(
                currentOption = currentOption,
                options = options,
                onClick = { currentOption = it },
                menuBackgroundColor = ZenGardenTheme.colors.watering,
                menuTextColor = ZenGardenTheme.colors.onWatering,
                textColor = ZenGardenTheme.colors.onPrimary,
                backgroundColor = ZenGardenTheme.colors.primary,
                shape = CircleShape,
                paddingValues = PaddingValues(5.dp),
                style = ZenGardenTheme.typography.label,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                ,
                label = {
                    Text(
                        text = "\uD83D\uDCA6 Waterign ",
                        style = ZenGardenTheme.typography.label,
                        color = ZenGardenTheme.colors.onWatering,
                        modifier = Modifier

                            .background(
                                color = ZenGardenTheme.colors.watering,
                                shape = CircleShape
                            )
                            .padding(10.dp, 5.dp)
                    )
                }
            )

            Spacer(Modifier.height(10.dp))

            DropDownTextField(
                currentOption = currentOption,
                options = options,
                onClick = { currentOption = it },
                menuBackgroundColor = ZenGardenTheme.colors.lightLevel,
                menuTextColor = ZenGardenTheme.colors.onLightLevel,
                textColor = ZenGardenTheme.colors.onPrimary,
                backgroundColor = ZenGardenTheme.colors.primary,
                shape = CircleShape,
                paddingValues = PaddingValues(5.dp),
                style = ZenGardenTheme.typography.label,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                ,
                label = {
                    Text(
                        text = "☀\uFE0F Light level ",
                        style = ZenGardenTheme.typography.label,
                        color = ZenGardenTheme.colors.onLightLevel,
                        modifier = Modifier
                            .background(
                                color = ZenGardenTheme.colors.lightLevel,
                                shape = CircleShape
                            )
                            .padding(10.dp, 5.dp)
                    )
                }

            )
        }
    }
}
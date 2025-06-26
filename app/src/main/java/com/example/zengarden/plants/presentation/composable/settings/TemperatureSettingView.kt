package com.example.zengarden.plants.presentation.composable.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.zengarden.plants.presentation.composable.components.CustomTextField
import com.example.zengarden.ui.theme.ZenGardenTheme

@Composable
fun TemperatureSettingView(
    minTempValue: String,
    maxTempValue: String,
    onMinValueChange: (String) -> Unit,
    onMaxValueChange: (String) -> Unit,
    modifier: Modifier,
) {
    val shape = RoundedCornerShape(10.dp)

    Row (
       verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
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

        Spacer(Modifier.width(5.dp))

        Text(
            text = "From ",
            style = ZenGardenTheme.typography.label,
            color = ZenGardenTheme.colors.onTretiary,
        )

        CustomTextField(
            value = minTempValue,
            onValueChange = onMinValueChange,
            placeholder = "0",
            backgroundColor = ZenGardenTheme.colors.onTretiary,
            style = ZenGardenTheme.typography.body,
            shape = shape,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            textColor = ZenGardenTheme.colors.tretiary,
            modifier = Modifier
                .width(40.dp)
        )

        Text(
            text = " to ",
            style = ZenGardenTheme.typography.label,
            color = ZenGardenTheme.colors.onTretiary,

        )

        CustomTextField(
            value = maxTempValue,
            onValueChange = onMaxValueChange,
            backgroundColor = ZenGardenTheme.colors.onTretiary,
            style = ZenGardenTheme.typography.body,
            placeholder = "0",
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            shape = shape,
            textColor = ZenGardenTheme.colors.tretiary,
            modifier = Modifier
                .width(40.dp)
        )

        Text(
            text = " °C ",
            style = ZenGardenTheme.typography.label,
            color = ZenGardenTheme.colors.onTretiary,

            )
    }
}
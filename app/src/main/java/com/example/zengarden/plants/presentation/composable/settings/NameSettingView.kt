package com.example.zengarden.plants.presentation.composable.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.zengarden.plants.presentation.composable.components.CustomTextField
import com.example.zengarden.ui.theme.ZenGardenTheme

@Composable
fun NameSettingView(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
) {
    CustomTextField(
        value = value,
        onValueChange = onValueChange,
        shape = CircleShape,
        modifier = modifier,
        style = ZenGardenTheme.typography.label,
        paddingValues = PaddingValues(5.dp),
        backgroundColor = ZenGardenTheme.colors.tretiary,
        textColor = ZenGardenTheme.colors.onTretiary,
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
        }
    )
}
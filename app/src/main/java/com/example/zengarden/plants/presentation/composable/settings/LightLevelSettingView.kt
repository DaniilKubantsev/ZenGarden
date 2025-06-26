package com.example.zengarden.plants.presentation.composable.settings



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.zengarden.R
import com.example.zengarden.plants.presentation.composable.components.DropDownTextField
import com.example.zengarden.ui.theme.ZenGardenTheme

@Composable
fun LightLevelSettingView(
    value: String,
    onClick: (String) -> Unit,
    options: List<String>,
    modifier: Modifier,
) {
    DropDownTextField(
        currentOption = value,
        options = options,
        onClick = onClick,
        menuBackgroundColor = ZenGardenTheme.colors.lightLevel,
        menuTextColor = ZenGardenTheme.colors.onLightLevel,
        textColor = ZenGardenTheme.colors.onTretiary,
        backgroundColor = ZenGardenTheme.colors.tretiary,
        shape = CircleShape,
        paddingValues = PaddingValues(5.dp),
        style = ZenGardenTheme.typography.label,
        modifier = modifier
        ,
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
        }
    )
}
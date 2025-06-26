package com.example.zengarden.plants.presentation.composable.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.zengarden.plants.presentation.composable.components.CustomTextField
import com.example.zengarden.ui.theme.ZenGardenTheme

@Composable
fun NoteSettingView(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier
) {
    Column(
        modifier = modifier
    ) {
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

        Spacer(Modifier.height(5.dp))

        CustomTextField(
            value = value,
            onValueChange = onValueChange,
            backgroundColor = ZenGardenTheme.colors.tretiary,
            style = ZenGardenTheme.typography.body,
            shape = RoundedCornerShape(25.dp),
            minLines = 3,
            textColor = ZenGardenTheme.colors.onTretiary,
            singleLine = false,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
                .height(100.dp)

        )
    }
}
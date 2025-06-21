package com.example.zengarden.auth.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MonotonicFrameClock
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zengarden.auth.presentation.AuthEvent
import com.example.zengarden.ui.theme.ZenGardenTheme

@Composable
fun ActionButton(
    onClick: () -> Unit,
    text: String = "",
    enabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    Button (
        onClick = { onClick() },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = ZenGardenTheme.colors.accent,
            contentColor = ZenGardenTheme.colors.onAccent
        )
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp
            ),
        )
    }
}


@Preview
@Composable
fun ActionButtonPreview() {
    ZenGardenTheme {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(ZenGardenTheme.colors.background)
        ) {
            ActionButton(
                onClick = {},

                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )
        }
    }
}
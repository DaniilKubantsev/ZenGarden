package com.example.zengarden.registration.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.zengarden.ui.theme.Parchment

@Composable
fun RegistrationScreen(
    registrationViewModel: RegistrationViewModel = viewModel()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Parchment)
    ) {

    }
}


@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview(){
    RegistrationScreen()
}
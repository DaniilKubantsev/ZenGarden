package com.example.zengarden.auth.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.zengarden.auth.presentation.composables.SignInScreen
import com.example.zengarden.auth.presentation.composables.SignUpScreen

@Composable
fun AuthScreen(
    viewModel: AuthViewModel,
    paddingValues: PaddingValues,
    modifier: Modifier,
) {
    val state = viewModel.state.collectAsState()

    when (state.value) {
        
        is AuthState.SignUpState ->
            SignUpScreen(
                paddingValues = paddingValues,
                state = state.value as AuthState.SignUpState,
                onEvent = viewModel::obtainEvent,
                modifier = modifier
            )
        is AuthState.SignInState -> {
            SignInScreen(
                paddingValues = paddingValues,
                state = state.value as AuthState.SignInState,
                onEvent = viewModel::obtainEvent,
                modifier = modifier
            )
        }
        is AuthState.IdleState -> {}
    }
}

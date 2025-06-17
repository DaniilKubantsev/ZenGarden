package com.example.zengarden.auth.presentation

import androidx.compose.ui.text.input.PasswordVisualTransformation

sealed interface AuthState {
    data class SignUpState(
        val username: String = "",
        val password: String = "",
        val confirmPassword: String = "",
        val error: String = "",
        val isLoading: Boolean = false,
    ) : AuthState

    data class SignInState(
        val username: String = "",
        val password: String = "",
        val error: String = "",
        val isLoading: Boolean = false,
    ) : AuthState

    data object IdleState : AuthState
}
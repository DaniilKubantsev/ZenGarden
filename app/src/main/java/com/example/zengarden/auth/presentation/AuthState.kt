package com.example.zengarden.auth.presentation

sealed interface AuthState {
    data class SignUpState(
        val username: String = "",
        val password: String = "",
        val confirmPassword: String = "",
        val error: String? = null,
        val isLoading: Boolean = false,
    ) : AuthState

    data class SignInState(
        val username: String = "",
        val password: String = "",
        val error: String? = "aljskdhfljkashdfa",
        val isLoading: Boolean = false,
    ) : AuthState

    data object IdleState : AuthState
}
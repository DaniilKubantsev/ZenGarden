package com.example.zengarden.auth.presentation

sealed interface AuthEvent {
    data class OnSignUpUsernameChanged(val value: String) : AuthEvent
    data class OnSignUpPasswordChanged(val value: String) : AuthEvent
    data class OnSignUpConfirmPasswordChanged(val value: String) : AuthEvent
    data object SubmitSignUp : AuthEvent

    data class OnSignInUsernameChanged(val value: String) : AuthEvent
    data class OnSignInPasswordChanged(val value: String) : AuthEvent
    data object SubmitSignIn : AuthEvent

    data object SwitchToSignUp : AuthEvent
    data object SwitchToSignIn : AuthEvent
}
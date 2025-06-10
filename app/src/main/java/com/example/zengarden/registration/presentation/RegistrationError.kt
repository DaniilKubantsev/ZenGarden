package com.example.zengarden.registration.presentation

sealed class RegistrationError {
    data object PasswordMismatch : RegistrationError()
    data object UserAlreadyExists : RegistrationError()
    data object NetworkError : RegistrationError()
}
package com.example.zengarden.registration.presentation

data class RegistrationState(
    val username: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val errorMessage: String = "",
)
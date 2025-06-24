package com.example.zengarden.auth.domain.repository

data class SignUpCredentials(
    val username: String,
    val password: String,
    val confirmPassword: String,
)

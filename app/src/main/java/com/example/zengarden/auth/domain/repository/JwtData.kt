package com.example.zengarden.auth.domain.repository

data class JwtData(
    val accessToken: String,
    val tokenType: String,
)

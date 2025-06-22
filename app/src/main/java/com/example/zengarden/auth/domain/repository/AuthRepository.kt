package com.example.zengarden.auth.domain.repository

interface AuthRepository {
    suspend fun register(request: SignUpRequest): RegistrationResponse
}
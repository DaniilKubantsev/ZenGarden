package com.example.zengarden.auth.domain.repository

import com.example.zengarden.core.utils.Resource

interface AuthRepository {
    suspend fun signUp(credentials: SignUpCredentials): Resource<JwtData>
    suspend fun signIn(credentials: SignInCredentials): Resource<JwtData>
}
package com.example.zengarden.auth.data.auth_api

import com.example.zengarden.auth.domain.repository.AuthRepository
import com.example.zengarden.auth.domain.repository.RegistrationRequest
import com.example.zengarden.auth.domain.repository.RegistrationResponse

class AuthRepositoryImpl(
    private val authApi: AuthApi
): AuthRepository {
    override suspend fun register(request: RegistrationRequest): RegistrationResponse {
        val response = authApi.register(registrationRequest = request as RegistrationRequestImpl)

        if (response.isSuccessful) {
            val body = response.body() ?: throw Exception("Empty response")
            return SuccessRegistrationResponseImpl(
                accessToken = body.accessToken,
                tokenType = body.tokenType
            )
        }
        else {
            val errorJson = response.errorBody()?.string()
            // распарсить и пробросить ошибку по-своему
            throw Exception("Ошибка регистрации: $errorJson")
        }
    }
}


fun createAuthRepositoryImpl(): AuthRepositoryImpl {
    return AuthRepositoryImpl(authApi = createAuthApi())
}
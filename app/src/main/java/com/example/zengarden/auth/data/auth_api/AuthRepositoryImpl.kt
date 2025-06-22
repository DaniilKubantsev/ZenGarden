package com.example.zengarden.auth.data.auth_api

import com.example.zengarden.auth.domain.repository.AuthRepository
import com.example.zengarden.auth.domain.repository.SignUpRequest
import com.example.zengarden.auth.domain.repository.RegistrationResponse

class AuthRepositoryImpl(
    private val authApi: AuthApi
): AuthRepository {
    override suspend fun register(request: SignUpRequest): RegistrationResponse {
        val response = authApi.register(registrationRequest = request as RegistrationRequestImpl)

        if (response.isSuccessful) {
            val body = response.body() ?: throw Exception("Empty response")
            return SuccessRegistrationResponseImpl(
                accessToken = body.accessToken,
                tokenType = body.tokenType
            )
        }
        else {
            val errorJson = response.errorBody().toString()
            val errorCode = response.code()
            throw Exception("Ошибка регистрации: $errorJson\t$errorCode")
        }
    }
}


//fun createAuthRepositoryImpl(): AuthRepositoryImpl {
//    return AuthRepositoryImpl(authApi = createAuthApi())
//}
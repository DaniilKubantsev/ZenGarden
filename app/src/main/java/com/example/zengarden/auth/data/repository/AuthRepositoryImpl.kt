package com.example.zengarden.auth.data.repository

import com.example.zengarden.auth.data.remote.AuthApi
import com.example.zengarden.auth.data.remote.SingUpRequest
import com.example.zengarden.core.utils.Resource
import com.example.zengarden.auth.domain.repository.AuthRepository
import com.example.zengarden.auth.domain.repository.JwtData
import com.example.zengarden.auth.domain.repository.SignInCredentials
import com.example.zengarden.auth.domain.repository.SignUpCredentials

class AuthRepositoryImpl(
    private val authApi: AuthApi
) : AuthRepository {
    override suspend fun signUp(credentials: SignUpCredentials): Resource<JwtData> {
        return try {
            val response = authApi.sighUp(
                singUpRequest = SingUpRequest(
                    username = credentials.username,
                    password = credentials.password,
                    password2 = credentials.confirmPassword,
                )
            )

            if (response.isSuccessful) {
                Resource.Success(
                    data = JwtData(
                        accessToken = response.body()!!.accessToken,
                        tokenType = response.body()!!.tokenType,
                    )
                )
            } else {
                Resource.Error(message = "Server error. Code ${response.code()}")
            }
        } catch (e: Exception) {
            Resource.Error(message = "Network error: ${e.message}")
        }
    }

    override suspend fun signIn(credentials: SignInCredentials): Resource<JwtData> {
        return try {
            val response = authApi.signIn(
                username = credentials.username,
                password = credentials.password,
            )

            if (response.isSuccessful) {
                Resource.Success(
                    data = JwtData(
                        accessToken = response.body()!!.accessToken,
                        tokenType = response.body()!!.tokenType,
                    )
                )
            } else {
                Resource.Error(message = "Server error. Code ${response.code()}")
            }
        } catch (e: Exception) {
            Resource.Error(message = "Network error: ${e.message}")
        }
    }

}


//fun createAuthRepositoryImpl(): AuthRepositoryImpl {
//    return AuthRepositoryImpl(authApi = createAuthApi())
//}
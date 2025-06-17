package com.example.zengarden.auth.data.auth_api

import com.example.zengarden.auth.domain.repository.RegistrationRequest
import com.example.zengarden.auth.domain.repository.RegistrationResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("/api/v1/auth/register")
    suspend fun register(
        @Body registrationRequest: RegistrationRequestImpl
    ): Response<SuccessRegistrationResponseImpl>
}

private const val BASE_URL = "http://46.8.232.177:8000"

private val loggingInterceptor = HttpLoggingInterceptor().apply {
    setLevel(HttpLoggingInterceptor.Level.BODY)
}

private val httpClient = OkHttpClient.Builder()
    .addInterceptor(loggingInterceptor)
    .build()


private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(httpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

fun createAuthApi(): AuthApi = retrofit.create(AuthApi::class.java)
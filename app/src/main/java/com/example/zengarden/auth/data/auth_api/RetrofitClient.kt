package com.example.zengarden.auth.data.auth_api

import com.example.zengarden.BuildConfig
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


fun createRetrofit(): Retrofit {
    val BASE_URL = BuildConfig.BASE_URL

    val loggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    val httpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}



fun createAuthApi(retrofit:Retrofit): AuthApi = retrofit.create(AuthApi::class.java)
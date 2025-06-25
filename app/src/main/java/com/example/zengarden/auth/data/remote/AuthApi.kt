package com.example.zengarden.auth.data.remote


import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {
    @POST("/api/v1/auth/register")
    suspend fun sighUp(@Body singUpRequest: SingUpRequest): Response<JwtResponse>

    @FormUrlEncoded
    @POST("/api/v1/auth/token")
    suspend fun signIn(
        @Field("grand_type") grandType: String = "password",
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("scope") scope: String = "",
        @Field("client_id") clientId: String = "",
        @Field("client_secret") clientSecret: String = "",
    ): Response<JwtResponse>
}

fun createAuthApi(retrofit: Retrofit): AuthApi = retrofit.create(AuthApi::class.java)
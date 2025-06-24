package com.example.zengarden.auth.data.repository

import com.google.gson.annotations.SerializedName

data class SingUpRequest(
    @SerializedName("username") val username: String = "",
    @SerializedName("password") val password: String = "",
    @SerializedName("password2") val password2: String = "",
)

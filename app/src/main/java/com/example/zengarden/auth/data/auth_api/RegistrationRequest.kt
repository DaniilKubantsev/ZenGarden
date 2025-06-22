package com.example.zengarden.auth.data.auth_api

import com.example.zengarden.auth.domain.repository.SignUpRequest
import com.google.gson.annotations.SerializedName

data class RegistrationRequestImpl(
    @SerializedName("username") val username: String = "",
    @SerializedName("password") val password: String = "",
    @SerializedName("password2") val password2: String = "",
) : SignUpRequest

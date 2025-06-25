package com.example.zengarden.auth.data.remote

import com.google.gson.annotations.SerializedName

data class JwtResponse(
    @SerializedName("access_token") val accessToken : String = "",
    @SerializedName("token_type") val tokenType : String = "",
)

package com.example.zengarden.auth.data.auth_api

import com.example.zengarden.auth.domain.repository.RegistrationResponse
import com.google.gson.annotations.SerializedName

data class SuccessRegistrationResponseImpl(
    @SerializedName("access_token") val accessToken : String = "",
    @SerializedName("token_type") val tokenType : String = "",
) : RegistrationResponse

data class ErrorRegistrationResponse(
    @SerializedName("detail") val detail: List<ErrorDetail>
)

data class ErrorDetail(
    @SerializedName("loc") val loc: List<Pair<String, Int>>,
    @SerializedName("msg") val msg: String,
    @SerializedName("type") val type: String
)
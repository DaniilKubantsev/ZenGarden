package com.example.zengarden.core.network

interface TokenManager {
    fun saveToken(token: String)

    fun getToken(): String?

    fun clearToken()
}
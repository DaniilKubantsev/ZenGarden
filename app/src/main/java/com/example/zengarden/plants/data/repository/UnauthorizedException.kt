package com.example.zengarden.plants.data.repository

class UnauthorizedException(
    override val message: String,
    val code: Int
): Exception(message)
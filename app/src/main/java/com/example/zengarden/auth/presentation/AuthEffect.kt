package com.example.zengarden.auth.presentation

sealed class AuthEffect {
    data object NavigateToMain : AuthEffect()
}
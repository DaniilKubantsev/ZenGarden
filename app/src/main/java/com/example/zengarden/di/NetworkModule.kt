package com.example.zengarden.di

import com.example.zengarden.auth.data.auth_api.AuthApi
import com.example.zengarden.auth.data.auth_api.createAuthApi
import com.example.zengarden.auth.data.auth_api.createRetrofit
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    single<Retrofit> { createRetrofit() }
    single<AuthApi> { createAuthApi(get()) }
}
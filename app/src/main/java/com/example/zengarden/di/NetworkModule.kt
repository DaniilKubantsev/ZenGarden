package com.example.zengarden.di

import com.example.zengarden.auth.data.remote.AuthApi
import com.example.zengarden.auth.data.remote.createAuthApi
import com.example.zengarden.core.network.createRetrofit
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    single<Retrofit> { createRetrofit() }
    single<AuthApi> { createAuthApi(get()) }
}
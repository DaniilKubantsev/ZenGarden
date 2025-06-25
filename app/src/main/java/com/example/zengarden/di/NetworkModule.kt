package com.example.zengarden.di

import com.example.zengarden.auth.data.remote.AuthApi
import com.example.zengarden.auth.data.remote.createAuthApi
import com.example.zengarden.core.network.JwtManager
import com.example.zengarden.core.network.TokenManager
import com.example.zengarden.core.network.createRetrofit
import com.example.zengarden.plants.data.remote.PlantsApi
import com.example.zengarden.plants.data.remote.createPlantsApi
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    single<TokenManager> { JwtManager(androidContext()) }
    single<Retrofit> { createRetrofit(get()) }
    single<AuthApi> { createAuthApi(get()) }
    single<PlantsApi> { createPlantsApi(get()) }
}
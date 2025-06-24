package com.example.zengarden.core.network

import com.example.zengarden.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createRetrofit(): Retrofit {
    val baseUrl = BuildConfig.BASE_URL

    val loggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    val httpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
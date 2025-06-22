package com.example.zengarden.di

import com.example.zengarden.auth.data.auth_api.AuthRepositoryImpl
import com.example.zengarden.auth.domain.repository.AuthRepository
import com.example.zengarden.auth.presentation.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val authModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    viewModel<AuthViewModel> { AuthViewModel(get()) }
}
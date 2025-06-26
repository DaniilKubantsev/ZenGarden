package com.example.zengarden.di

import com.example.zengarden.plants.data.repository.PlantsRepositoryImpl
import com.example.zengarden.plants.domain.repository.PlantsRepository
import com.example.zengarden.plants.presentation.PlantsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val plantsModule = module {
    single<PlantsRepository> { PlantsRepositoryImpl(get()) }
    viewModel<PlantsViewModel> { PlantsViewModel(get(), get()) }
}
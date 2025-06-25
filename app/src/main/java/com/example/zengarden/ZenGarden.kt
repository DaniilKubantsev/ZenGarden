package com.example.zengarden

import android.app.Application
import com.example.zengarden.di.authModule
import com.example.zengarden.di.networkModule
import com.example.zengarden.di.plantsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ZenGarden: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ZenGarden)
            modules(
                networkModule,
                authModule,
                plantsModule,
            )
        }
    }
}
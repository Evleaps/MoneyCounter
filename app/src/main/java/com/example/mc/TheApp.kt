package com.example.mc

import android.app.Application
import com.example.mc.di.appModule
import com.example.mc.di.presentersModule
import org.koin.android.ext.android.startKoin

class TheApp : Application() {

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin(this, listOf(appModule, presentersModule))
    }

}

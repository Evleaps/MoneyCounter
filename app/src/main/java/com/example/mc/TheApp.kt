package com.example.mc

import android.app.Application
import com.example.mc.common.Enviroment
import com.example.mc.di.appModule
import com.example.mc.di.presentersModule
import com.pixplicity.easyprefs.library.Prefs
import org.koin.android.ext.android.startKoin

class TheApp : Application() {

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin(this, listOf(appModule, presentersModule))

        Prefs.Builder()
            .setContext(this)
            .setMode(MODE_PRIVATE)
            .setPrefsName(Enviroment.PREFERENCE_NAME)
            .setUseDefaultSharedPreference(true)
            .build()
    }

}

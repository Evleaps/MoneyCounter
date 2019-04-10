package com.example.mc

import android.app.Application
import com.example.mc.common.Enviroment
import com.example.mc.di.appModules
import com.example.mc.di.presentersModule
import com.facebook.stetho.Stetho
import com.pixplicity.easyprefs.library.Prefs
import org.koin.android.ext.android.startKoin

class TheApp : Application() {

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin(this, appModules + presentersModule)

        Prefs.Builder()
            .setContext(this)
            .setMode(MODE_PRIVATE)
            .setPrefsName(Enviroment.PREFERENCE_NAME)
            .setUseDefaultSharedPreference(true)
            .build()

        Stetho.initializeWithDefaults(this)
    }

}

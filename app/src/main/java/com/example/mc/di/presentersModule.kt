package com.example.mc.di

import android.content.pm.PackageManager
import com.example.mc.data.repository.DataRepository
import com.example.mc.feature.aboutScreen.AboutPresenter
import com.example.mc.feature.counterScreen.CounterPresenter
import com.example.mc.feature.splashScreen.SplashPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val presentersModule = module {
    factory { CounterPresenter(get(), get() as DataRepository) }
    factory { SplashPresenter() }
    factory {
        val appVersion = try {
            androidContext().packageManager.getPackageInfo(androidContext().packageName, 0).versionName
        } catch (e: PackageManager.NameNotFoundException) {
            ""
        }

        AboutPresenter(appVersion)
    }
}

package com.example.mc.di

import com.example.mc.feature.counterScreen.CounterPresenter
import com.example.mc.feature.splashScreen.SplashPresenter
import org.koin.dsl.module.module

val presentersModule = module {
    factory { CounterPresenter() }
    factory { SplashPresenter() }
}
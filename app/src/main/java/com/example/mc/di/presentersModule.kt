package com.example.mc.di

import com.example.mc.feature.mainScreen.CounterPresenter
import com.example.mc.feature.splash.SplashPresenter
import org.koin.dsl.module.module

val presentersModule = module {

    factory { CounterPresenter() }
    factory { SplashPresenter() }

}
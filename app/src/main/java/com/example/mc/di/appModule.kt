package com.example.mc.di

import androidx.room.Room
import com.example.mc.common.DATABASE_NAME
import com.example.mc.core.router.IRouter
import com.example.mc.core.router.Router
import com.example.mc.data.db.AppDatabase
import com.example.mc.data.repository.DataRepository
import com.example.mc.data.repository.async.AsyncDataRepository
import com.example.mc.data.repository.async.IAsyncRepository
import com.example.mc.feature.mainScreen.CounterPresenter
import com.example.mc.feature.splash.SplashActivity
import com.example.mc.feature.splash.SplashPresenter
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val appModule = module {

    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, DATABASE_NAME).build()
    }

    single { get<AppDatabase>().getCounterDao() }

    single { AsyncDataRepository(get()) }

    single<IAsyncRepository> { AsyncDataRepository(get()) }

    single { DataRepository(get()) }

    single { Router(androidContext()) }

}
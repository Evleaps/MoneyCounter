package com.example.mc.di

import androidx.room.Room
import com.example.mc.common.DATABASE_NAME
import com.example.mc.data.db.AppDatabase
import com.example.mc.data.repository.DataRepository
import com.example.mc.data.repository.async.AsyncDataRepository
import com.example.mc.data.repository.async.IAsyncRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

val appModule = module {

    //Database
    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, DATABASE_NAME).build()
    }
    single { get<AppDatabase>().getCounterDao() }

    //Repository
    single { AsyncDataRepository(get()) }
    single<IAsyncRepository> { AsyncDataRepository(get()) }
    single { DataRepository(get()) }

    //Cicerone
    single { Cicerone.create() as Cicerone<Router> }
    single { get<Cicerone<Router>>().router }
    single { get<Cicerone<Router>>().navigatorHolder }

}
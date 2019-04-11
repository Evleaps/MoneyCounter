package com.example.mc.di

import androidx.room.Room
import com.example.mc.common.Enviroment
import com.example.mc.data.db.AppDatabase
import com.example.mc.data.repository.DataRepository
import com.example.mc.data.repository.PrefsManager
import com.example.mc.data.repository.local.LocalRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

val databaseModule = module {
    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, Enviroment.DATABASE_NAME).build()
    }
    single { get<AppDatabase>().getCounterDao() }
}

val repositoryModule = module {
    single { PrefsManager() }
    single { DataRepository(get() as LocalRepository) }
    single { LocalRepository(get()) }
}

val ciceroneModule = module {
    single { Cicerone.create() as Cicerone<Router> }
    single { get<Cicerone<Router>>().router }
    single { get<Cicerone<Router>>().navigatorHolder }
}

val appModules = listOf(databaseModule, repositoryModule, ciceroneModule)
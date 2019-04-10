package com.example.mc.data.db

import android.util.Log
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mc.common.Enviroment
import com.example.mc.data.model.dao.CounterDao
import com.example.mc.data.model.entity.Payment

@Database(entities = [Payment::class], version = Enviroment.DB_VERSION, exportSchema = false )
abstract class AppDatabase : RoomDatabase() {
    /**
     * @return The DAO for the DebugMessage table.
     */
    abstract fun getCounterDao(): CounterDao

    init { Log.d(TAG, "Instance Database") }

    companion object {
        private val TAG = AppDatabase::class.java.simpleName
    }
}
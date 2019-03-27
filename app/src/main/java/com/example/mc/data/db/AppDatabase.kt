package com.example.mc.data.db

import android.util.Log
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mc.common.DB_VERSION
import com.example.mc.data.model.dao.CounterDao

@Database(entities = [], version = DB_VERSION, exportSchema = false )
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
package com.example.mc.data.model.dao

import androidx.room.*
import com.example.mc.common.Enviroment
import com.example.mc.data.model.entity.Payment

@Dao
abstract class CounterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPayment(payment: Payment)

    @Query("SELECT * FROM ${Enviroment.PAYMENTS}")
    abstract fun getAllPayments(): List<Int>

    @Transaction
    open fun getTotal(): Int {
        return getAllPayments().sum()
    }

}
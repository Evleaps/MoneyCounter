package com.example.mc.data.model.dao

import androidx.room.*
import com.example.mc.common.Enviroment
import com.example.mc.data.model.entity.Payment

@Dao
abstract class CounterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertPayment(payment: Payment)

    @Query("SELECT * FROM ${Enviroment.PAYMENTS}")
    abstract suspend fun getAllPayments(): List<Payment>

    @Transaction
    open suspend fun getTotal() = getAllPayments().map { it.payment }.sum()

}
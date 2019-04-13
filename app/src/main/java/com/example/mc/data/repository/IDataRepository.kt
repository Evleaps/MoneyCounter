package com.example.mc.data.repository

interface IDataRepository {
    suspend fun addPayment(payment: Long)
    suspend fun getTotalPayments(): Long
}

package com.example.mc.data.repository

interface IDataRepository {
    suspend fun addPayment(payment: Int)
    suspend fun getTotalPayments(): Int
}

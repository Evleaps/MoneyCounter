package com.example.mc.data.repository.local

interface ILocalRepository {
    suspend fun addPayment(payment: Int)
    suspend fun getTotalPayments(): Int
}

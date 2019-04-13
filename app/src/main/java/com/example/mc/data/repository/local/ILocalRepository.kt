package com.example.mc.data.repository.local

interface ILocalRepository {
    suspend fun addPayment(payment: Long)
    suspend fun getTotalPayments(): Long
}

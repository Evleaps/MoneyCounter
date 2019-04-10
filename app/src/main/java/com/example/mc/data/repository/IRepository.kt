package com.example.mc.data.repository

interface IRepository {
    suspend fun addPayment(payment: Int)
    suspend fun getTotalPayments(): Int
}
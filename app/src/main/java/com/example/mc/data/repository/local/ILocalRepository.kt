package com.example.mc.data.repository.local

interface ILocalRepository {
    fun addPayment(payment: Int)
    fun getTotalPayments(): Int
}
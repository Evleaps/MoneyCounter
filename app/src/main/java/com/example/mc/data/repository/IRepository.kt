package com.example.mc.data.repository

interface IRepository {
    fun addPayment(payment: Int)
    fun getTotalPayments(): Int
}
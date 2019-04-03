package com.example.mc.data.repository

import com.example.mc.data.repository.local.ILocalRepository

class DataRepository(private val localRepository: ILocalRepository) : IRepository {
    override fun addPayment(payment: Int) {
        localRepository.addPayment(payment)
    }

    override fun getTotalPayments(): Int {
        return localRepository.getTotalPayments()
    }
}
package com.example.mc.data.repository

import android.util.Log
import com.example.mc.data.repository.local.LocalRepository
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class DataRepository : IRepository, KoinComponent {

    private val localRepository: LocalRepository by inject()

    init {
        Log.d("ROMAN", "DataRepository")
    }

    override suspend fun addPayment(payment: Int) {
        Log.d("ROMAN", "DataRepository2")
        localRepository.addPayment(payment)
    }

    override suspend fun getTotalPayments(): Int {
        return localRepository.getTotalPayments()
    }
}
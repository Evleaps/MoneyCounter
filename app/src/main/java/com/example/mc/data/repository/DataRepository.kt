package com.example.mc.data.repository

import android.util.Log
import com.example.mc.data.repository.local.ILocalRepository

class DataRepository(private val localRepository: ILocalRepository) : IDataRepository {

    init { Log.d("ROMAN", "DataRepository") }

    override suspend fun addPayment(payment: Int) {
        Log.d("ROMAN", "DataRepository2")
        localRepository.addPayment(payment)
    }

    override suspend fun getTotalPayments(): Int {
        return localRepository.getTotalPayments()
    }
}

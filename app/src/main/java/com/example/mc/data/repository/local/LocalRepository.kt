package com.example.mc.data.repository.local

import com.example.mc.data.model.dao.CounterDao
import com.example.mc.data.model.entity.Payment
import kotlinx.coroutines.runBlocking
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class LocalRepository : ILocalRepository, KoinComponent{

    private val counterDao: CounterDao by inject()

    override suspend fun addPayment(payment: Int) = runBlocking {
        counterDao.insertPayment(Payment(payment))
    }

    override suspend fun getTotalPayments(): Int {
        return counterDao.getTotal()
    }
}
package com.example.mc.data.repository.local

import com.example.mc.data.model.dao.CounterDao

class LocalRepository(private val counterDao: CounterDao) : ILocalRepository {

    override fun addPayment(payment: Int) {
   //     counterDao.insertPayment(payment)
    }

    override fun getTotalPayments(): Int {
  //      return counterDao.getTotal()
        return 7
    }
}
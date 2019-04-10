package com.example.mc.feature.counterScreen

import com.example.mc.common.Utils.launchIO
import com.example.mc.common.Utils.toInt
import com.example.mc.core.presentation.BasePresenter
import com.example.mc.data.repository.DataRepository
import com.example.mc.data.repository.IRepository
import com.example.mc.data.repository.PrefsManager
import kotlinx.coroutines.runBlocking
import org.koin.standalone.inject

class CounterPresenter : BasePresenter<CounterContract.View>(), CounterContract.Presenter {
    private val prefs: PrefsManager by inject()
    private val repo: DataRepository by inject()

    override fun onViewCreated() {
        super.onViewCreated()
        if (prefs.getDefaultMonthPayment() > 0){
            view?.showGiveDefaultPaymentDialog()
        }
        getTotalPayments()
    }

    private fun getTotalPayments() {
       launchIO {
           val total = repo.getTotalPayments()
           view?.showTotal(total)
       }
    }

    override fun saveDefaultPayment(payment: String) {
        payment.toInt({
            prefs.setDefaultMonthPayment(it)
        }, {
            view?.showIncorrectCodeDialog(true)
        })
    }

    override fun addNewPayment() {
        val payment = prefs.getDefaultMonthPayment()
        if (payment > 0){
            launchIO { repo.addPayment(payment) }
        } else {
            view?.showGivePaymentDialog()
        }
    }

    override fun addNewPayment(payment: String) {
        payment.toInt({
            launchIO { repo.addPayment(it) }
        }, {
            view?.showIncorrectCodeDialog(false)
        })
    }
}

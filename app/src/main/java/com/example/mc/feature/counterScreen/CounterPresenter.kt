package com.example.mc.feature.counterScreen

import com.example.mc.common.Enviroment
import com.example.mc.common.isPositive
import com.example.mc.common.utils.launchIO
import com.example.mc.common.toInt
import com.example.mc.common.utils.launchMain
import com.example.mc.core.presentation.BasePresenter
import com.example.mc.data.repository.IDataRepository
import com.example.mc.data.repository.PrefsManager

class CounterPresenter(
    private val prefs: PrefsManager,
    private val repo: IDataRepository
) : BasePresenter<CounterContract.View>(), CounterContract.Presenter {

    override fun onViewCreated() {
        super.onViewCreated()
        if (prefs.getDefaultMonthPayment() == Enviroment.UNKNOWN_VALUE) {
            view?.showGiveDefaultPaymentDialog()
        }
        updateTotalPayments()
    }

    private fun updateTotalPayments() {
        launchMain {
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
        if (payment.isPositive()) {
            launchIO {
                repo.addPayment(payment)
                updateTotalPayments()
            }
        } else {
            view?.showGivePaymentDialog()
        }
    }

    override fun addNewPayment(payment: String) {
        payment.toInt({
            launchIO {
                repo.addPayment(it)
                updateTotalPayments()
            }
        }, {
            view?.showIncorrectCodeDialog(false)
        })
    }
}


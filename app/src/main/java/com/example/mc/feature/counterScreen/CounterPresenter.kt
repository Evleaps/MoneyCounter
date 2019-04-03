package com.example.mc.feature.counterScreen

import com.example.mc.common.Utils.toInt
import com.example.mc.core.presentation.BasePresenter
import com.example.mc.data.repository.IRepository
import com.example.mc.data.repository.PrefsManager

class CounterPresenter(
    private val prefs: PrefsManager,
    private val repo: IRepository
) : BasePresenter<CounterContract.View>(), CounterContract.Presenter {

    override fun onViewCreated() {
        super.onViewCreated()
        if (prefs.getDefaultMonthPayment() > 0){
            view?.showGiveDefaultPaymentDialog()
        }
        getTotalPayments()
    }

    private fun getTotalPayments() {
        val total = repo.getTotalPayments()
        view?.showTotal(total)
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
            repo.addPayment(payment)
        } else {
            view?.showGivePaymentDialog()
        }
    }

    override fun addNewPayment(payment: String) {
        payment.toInt({
            repo.addPayment(it)
        }, {
            view?.showIncorrectCodeDialog(false)
        })
    }
}

package com.example.mc.feature.counterScreen

import com.example.mc.common.utils.launchIO
import com.example.mc.common.utils.toInt
import com.example.mc.core.presentation.BasePresenter
import com.example.mc.data.repository.IDataRepository
import com.example.mc.data.repository.PrefsManager
import kotlinx.coroutines.Dispatchers

class CounterPresenter(
    private val prefs: PrefsManager,
    private val repo: IDataRepository
) : BasePresenter<CounterContract.View>(), CounterContract.Presenter {

    override fun onViewCreated() {
        super.onViewCreated()
        if (prefs.getDefaultMonthPayment() > 0) {
            view?.showGiveDefaultPaymentDialog()
        }
        getTotalPayments()
    }

    private fun getTotalPayments() {
        launchIO(Dispatchers.Main) {
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
        if (payment > 0) {
            launchIO { repo.addPayment(payment) }
        } else {
            view?.showGivePaymentDialog()
        }
    }

    override fun addNewPayment(payment: String) {
        payment.toInt({
            launchIO {
                repo.addPayment(it)
                getTotalPayments()
            }
        }, {
            view?.showIncorrectCodeDialog(false)
        })
    }
}

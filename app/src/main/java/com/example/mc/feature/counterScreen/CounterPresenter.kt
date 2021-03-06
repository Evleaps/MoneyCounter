package com.example.mc.feature.counterScreen

import com.example.mc.common.utils.launchIO
import com.example.mc.common.utils.launchMain
import com.example.mc.core.presentation.BasePresenter
import com.example.mc.data.repository.IDataRepository
import com.example.mc.data.repository.PrefsManager
import com.example.mc.router.Screens

class CounterPresenter(
    private val prefs: PrefsManager,
    private val repo: IDataRepository
) : BasePresenter<CounterContract.View>(), CounterContract.Presenter {

    override fun onViewCreated() {
        super.onViewCreated()
        if (prefs.getDefaultMonthPayment() == null) {
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
        if (payment.isNotBlank()) {
            prefs.setDefaultMonthPayment(payment)
        }
    }

    override fun addRegularPayment() {
        val defPayment = prefs.getDefaultMonthPayment()

        defPayment?.let {
            addNewPayment(defPayment)
        } ?: view?.showGivePaymentDialog()
    }

    override fun addNewPayment(payment: String) {
        launchIO {
            repo.addPayment(payment.toLong())
            updateTotalPayments()
        }
    }

    override fun onDefaultPaymentBtn() {
        view?.showGiveDefaultPaymentDialog()
    }

    override fun navigateToAboutScreen() {
        router.navigateTo(Screens.AboutScreen)
    }
}

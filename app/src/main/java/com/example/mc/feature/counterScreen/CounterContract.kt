package com.example.mc.feature.counterScreen

import com.example.mc.core.presentation.IBasePresenter
import com.example.mc.core.presentation.IBaseView

interface CounterContract {
    interface View : IBaseView {
        fun showTotal(total: Long)
        fun showGiveDefaultPaymentDialog()
        fun showGivePaymentDialog()
        fun showIncorrectCodeDialog(isDefaultPayment: Boolean)
    }

    interface Presenter : IBasePresenter {
        fun saveDefaultPayment(payment: String)
        fun addRegularPayment()
        fun addNewPayment(payment: String)

        // Navigation drawer
        fun onDefaultPaymentBtn()
        fun navigateToAboutScreen()
    }
}

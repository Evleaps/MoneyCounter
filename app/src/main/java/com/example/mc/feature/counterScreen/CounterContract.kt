package com.example.mc.feature.counterScreen

import com.example.mc.core.presentation.IBasePresenter
import com.example.mc.core.presentation.IBaseView

interface CounterContract {
    interface View : IBaseView {
        fun showTotal(total: Int)
        fun showGiveDefaultPaymentDialog()
        fun showGivePaymentDialog()
        fun showIncorrectCodeDialog(isDefaultPayment: Boolean)
    }

    interface Presenter : IBasePresenter {
        fun saveDefaultPayment(payment: String)
        fun addNewPayment(payment: String)
        fun addNewPayment()
    }
}

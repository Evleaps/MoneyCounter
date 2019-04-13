package com.example.mc.feature.common.dialogs

import android.content.Context
import com.example.mc.R
import com.example.mc.common.AlertParamsItem
import com.example.mc.common.showAlert
import com.example.mc.common.showAlertEditText

fun showGiveDefaultPayment(context: Context, okCallback: (defaultPayment: String) -> Unit) {
    showAlertEditText(
        params = AlertParamsItem(
            context = context,
            titleResId = R.string.give_payment,
            msgResId = R.string.give_payment_desc,
            posBtnResId = R.string.ok,
            negBtnResId = R.string.close
        ),
        onPositiveClick = { okCallback(it) },
        onNegativeClick = {}
    )
}

fun showGivePayment(context: Context, okCallback: (payment: String) -> Unit) {
    showAlertEditText(
        params = AlertParamsItem(
            context = context,
            titleResId = R.string.give_payment,
            msgResId = R.string.give_single_payment_desc,
            posBtnResId = R.string.ok,
            negBtnResId = R.string.close
        ),
        onPositiveClick = { okCallback(it) },
        onNegativeClick = {}
    )
}

fun showIncorrectNumberDialog(context: Context, okCallback: () -> Unit) {
    showAlert(
        params = AlertParamsItem(
            context = context,
            titleResId = R.string.error,
            msgResId = R.string.incorrect_int_desc,
            posBtnResId = R.string.repeat,
            negBtnResId = R.string.close
        ),
        onPositiveClick = { okCallback() },
        onNegativeClick = {}
    )
}

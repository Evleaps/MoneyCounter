package com.example.mc.feature.common.dialogs

import android.content.Context
import com.example.mc.R
import com.example.mc.common.Utils.showAlert
import com.example.mc.common.Utils.showAlertEditText

fun showGiveDefaultPayment(context: Context, okCallback: (defaultPayment: String) -> Unit) {
    showAlertEditText(
        context = context,
        titleResId = R.string.give_payment,
        msgResId = R.string.give_payment_desc,
        posBtnResId = R.string.ok,
        negBtnResId = R.string.close,
        onPositiveClick = { okCallback(it) },
        onNegativeClick = {}
    )
}

fun showGivePayment(context: Context, okCallback: (payment: String) -> Unit) {
    showAlertEditText(
        context = context,
        titleResId = R.string.give_payment,
        msgResId = R.string.give_single_payment_desc,
        posBtnResId = R.string.ok,
        negBtnResId = R.string.close,
        onPositiveClick = { okCallback(it) },
        onNegativeClick = {}
    )
}

fun showIncorrectNumberDialog(context: Context, okCallback: () -> Unit) {
    showAlert(
        context = context,
        titleResId = R.string.error,
        msgResId = R.string.incorrect_int_desc,
        posBtnResId = R.string.repeat,
        negBtnResId = R.string.close,
        onPositiveClick = { okCallback() },
        onNegativeClick = {}
    )
}
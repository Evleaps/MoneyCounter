package com.example.mc.common.utils

import android.app.AlertDialog
import android.text.InputFilter
import android.text.InputType
import android.widget.EditText
import com.example.mc.R

fun createAlert(
    params: AlertParamsItem,
    onPositiveClick: () -> Unit,
    onNegativeClick: () -> Unit,
    onDismiss: () -> Unit = {}
): AlertDialog {
    val builder = AlertDialog.Builder(params.context, R.style.MessageDialog)
    if (params.titleResId > 0) builder.setTitle(params.titleResId)
    builder.setMessage(params.msgResId)

    builder.setPositiveButton(params.posBtnResId) { _, _ -> onPositiveClick() }
    if (params.negBtnResId > 0) {
        builder.setNegativeButton(params.negBtnResId) { _, _ -> onNegativeClick() }
    }

    builder.setOnDismissListener { onDismiss() }

    return builder.create()
}

fun showAlert(
    params: AlertParamsItem,
    onPositiveClick: () -> Unit = {},
    onNegativeClick: () -> Unit = {}
) {
    createAlert(params, onPositiveClick, onNegativeClick).show()
}

fun showAlertEditText(
    params: AlertParamsItem,
    onPositiveClick: (answer: String) -> Unit = {},
    onNegativeClick: () -> Unit = {}
) {
    createAlertEditText(params, onPositiveClick, onNegativeClick).show()
}

fun createAlertEditText(
    params: AlertParamsItem,
    onPositiveClick: (answer: String) -> Unit,
    onNegativeClick: () -> Unit,
    onDismiss: () -> Unit = {}
): AlertDialog {
    val builder = AlertDialog.Builder(params.context, R.style.MessageDialog)
    if (params.titleResId > 0) builder.setTitle(params.titleResId)
    builder.setMessage(params.msgResId)

    val input = EditText(params.context)
    input.inputType = InputType.TYPE_CLASS_NUMBER
    input.filters = arrayOf(InputFilter.LengthFilter(15))
    builder.setView(input)

    builder.setPositiveButton(params.posBtnResId) { _, _ ->
        input.text.toString().run {
            if (isNotBlank()) onPositiveClick(this)
            else onNegativeClick
        }
    }

    if (params.negBtnResId > 0) {
        builder.setNegativeButton(params.negBtnResId) { _, _ -> onNegativeClick() }
    }

    builder.setOnDismissListener { onDismiss() }

    return builder.create()
}

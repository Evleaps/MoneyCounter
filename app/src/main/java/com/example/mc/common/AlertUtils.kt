package com.example.mc.common

import android.app.AlertDialog
import android.content.Context
import android.widget.EditText
import com.example.mc.R

fun createAlert(
    context: Context,
    titleResId: Int,
    msgResId: Int,
    posBtnResId: Int,
    negBtnResId: Int,
    onPositiveClick: () -> Unit,
    onNegativeClick: () -> Unit,
    onDismiss: () -> Unit = {}
): AlertDialog {
    val builder = AlertDialog.Builder(context, R.style.MessageDialog)
    if (titleResId > 0) builder.setTitle(titleResId)
    builder.setMessage(msgResId)

    builder.setPositiveButton(posBtnResId) { _, _ -> onPositiveClick() }
    if (negBtnResId > 0) {
        builder.setNegativeButton(negBtnResId) { _, _ -> onNegativeClick() }
    }

    builder.setOnDismissListener { onDismiss() }

    return builder.create()
}

fun showAlert(
    context: Context,
    titleResId: Int = -1,
    msgResId: Int,
    posBtnResId: Int = android.R.string.ok,
    negBtnResId: Int = -1,
    onPositiveClick: () -> Unit = {},
    onNegativeClick: () -> Unit = {}
) {
    createAlert(
        context,
        titleResId,
        msgResId,
        posBtnResId,
        negBtnResId,
        onPositiveClick,
        onNegativeClick
    ).show()
}

fun showAlertEditText(
    context: Context,
    titleResId: Int = -1,
    msgResId: Int,
    posBtnResId: Int = android.R.string.ok,
    negBtnResId: Int = -1,
    onPositiveClick: (answer: String) -> Unit = {},
    onNegativeClick: () -> Unit = {}
) {
    createAlertEditText(
        context,
        titleResId,
        msgResId,
        posBtnResId,
        negBtnResId,
        onPositiveClick,
        onNegativeClick
    ).show()
}

fun createAlertEditText(
    context: Context,
    titleResId: Int,
    msgResId: Int,
    posBtnResId: Int,
    negBtnResId: Int,
    onPositiveClick: (answer: String) -> Unit,
    onNegativeClick: () -> Unit,
    onDismiss: () -> Unit = {}
): AlertDialog {
    val builder = AlertDialog.Builder(context, R.style.MessageDialog)
    if (titleResId > 0) builder.setTitle(titleResId)
    builder.setMessage(msgResId)

    val input = EditText(context)
    builder.setView(input)

    builder.setPositiveButton(posBtnResId) { _, _ -> onPositiveClick(input.text.toString()) }
    if (negBtnResId > 0) {
        builder.setNegativeButton(negBtnResId) { _, _ -> onNegativeClick() }
    }

    builder.setOnDismissListener { onDismiss() }

    return builder.create()
}
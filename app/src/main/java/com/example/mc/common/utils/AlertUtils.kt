package com.example.mc.common.utils

import android.app.AlertDialog
import android.content.Context
import android.os.Build
import android.text.InputFilter
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import com.example.mc.R
import com.google.android.material.textfield.TextInputLayout

fun createAlert(
    params: AlertParamsItem,
    onPositiveClick: () -> Unit,
    onNegativeClick: () -> Unit,
    onDismiss: () -> Unit = {}
): AlertDialog {
    return AlertDialog.Builder(params.context, R.style.AlertDialog)
        .apply {
            if (params.titleResId > 0) setTitle(params.titleResId)
            if (params.msgResId > 0) setMessage(params.msgResId)

            setPositiveButton(params.posBtnResId) { _, _ -> onPositiveClick() }
            if (params.negBtnResId > 0) {
                setNegativeButton(params.negBtnResId) { _, _ -> onNegativeClick() }
            }

            setOnDismissListener { onDismiss() }
        }
        .create()
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
    return AlertDialog.Builder(params.context, R.style.AlertDialog)
        .apply {
            if (params.titleResId > 0) setTitle(params.titleResId)
            if (params.msgResId > 0) setMessage(params.msgResId)

            val input = getEditText(params.context)
            setView(getViewInLayout(input, params.context))

            setPositiveButton(params.posBtnResId) { _, _ ->
                input.text.toString().run {
                    if (isNotBlank()) onPositiveClick(this)
                    else onNegativeClick
                }
            }

            if (params.negBtnResId > 0) {
                setNegativeButton(params.negBtnResId) { _, _ -> onNegativeClick() }
            }

            setOnDismissListener { onDismiss() }
        }
        .create()
}

private fun getEditText(context: Context): EditText {
    return EditText(context).apply {
        gravity = Gravity.CENTER
        inputType = InputType.TYPE_CLASS_NUMBER
        filters = arrayOf(InputFilter.LengthFilter(15))

        setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) setText("")
            else setText(R.string.def_payment_hint)
        }

        setText(R.string.def_payment_hint)
        setPadding(0, 40, 0, 40)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            setTextColor(context.getColor(R.color.orange1))
            setBackgroundColor(context.getColor(R.color.blue1))
        }
    }
}

private fun getViewInLayout(view: View, context: Context): View {
    val frameLayoutParam = FrameLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    ).apply {
        setMargins(0, 20, 0, 20)
    }

    val textInputLayout = TextInputLayout(context).apply {
        layoutParams = frameLayoutParam
        addView(view)
    }

    return FrameLayout(context).apply {
        addView(textInputLayout)
    }
}

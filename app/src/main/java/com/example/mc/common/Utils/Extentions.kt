package com.example.mc.common.Utils

import java.lang.NumberFormatException

fun CharSequence?.isExistence() = !this.isNullOrEmpty()

fun String.toInt(success: (int: Int) -> Unit, error: () -> Unit) {
    try {
        success(java.lang.Integer.parseInt(this))
    } catch (e: NumberFormatException) {
        error()
    }
}

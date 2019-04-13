package com.example.mc.common

import java.lang.NumberFormatException

fun CharSequence?.isExistence() = !this.isNullOrEmpty()

fun String.toInt(success: (int: Int) -> Unit, error: () -> Unit) {
    try {
        success(java.lang.Integer.parseInt(this))
    } catch (e: NumberFormatException) {
        error()
    }
}

fun Int.isPositive() = this > 0

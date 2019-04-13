package com.example.mc.common

import java.lang.NumberFormatException

fun CharSequence?.isExistence() = !this.isNullOrEmpty()

fun String.toLong(success: (int: Long) -> Unit, error: () -> Unit) {
    try {
        return success(this.toLong())
    } catch (e: NumberFormatException) {
        error()
    }
}

fun Int.isPositive() = this > 0

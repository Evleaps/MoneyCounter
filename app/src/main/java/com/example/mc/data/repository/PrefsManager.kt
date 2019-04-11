package com.example.mc.data.repository

import com.pixplicity.easyprefs.library.Prefs

class PrefsManager {

    companion object {
        const val PREFS_DEFAULT_MONTH_PAYMENT = "PREFS_DEFAULT_MONTH_PAYMENT"
    }

    fun getDefaultMonthPayment() = Prefs.getInt(PREFS_DEFAULT_MONTH_PAYMENT, -1)
    fun setDefaultMonthPayment(defaultPayment: Int) = Prefs.putInt(PREFS_DEFAULT_MONTH_PAYMENT, defaultPayment)
}

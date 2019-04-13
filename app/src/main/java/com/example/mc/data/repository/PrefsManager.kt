package com.example.mc.data.repository

import com.pixplicity.easyprefs.library.Prefs

class PrefsManager {

    companion object {
        const val PREFS_DEFAULT_MONTH_PAYMENT = "PREFS_DEFAULT_MONTH_PAYMENT"
    }

    fun getDefaultMonthPayment() = Prefs.getString(PREFS_DEFAULT_MONTH_PAYMENT, null)
    fun setDefaultMonthPayment(defaultPayment: String) = Prefs.putString(PREFS_DEFAULT_MONTH_PAYMENT, defaultPayment)
}

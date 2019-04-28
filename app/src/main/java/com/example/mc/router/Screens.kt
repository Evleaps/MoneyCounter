package com.example.mc.router

import com.example.mc.feature.aboutScreen.AboutFragment
import com.example.mc.feature.counterScreen.CounterFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object CounterScreen : SupportAppScreen() {
        override fun getFragment() = CounterFragment()
    }

    object AboutScreen : SupportAppScreen() {
        override fun getFragment() = AboutFragment()
    }
}

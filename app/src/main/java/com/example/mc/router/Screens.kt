package com.example.mc.router

import com.example.mc.feature.mainScreen.CounterFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object CounterFragment : SupportAppScreen() {
        override fun getFragment() = CounterFragment()
    }
}
package com.example.mc.feature.splashScreen

import com.example.mc.core.presentation.IBasePresenter
import com.example.mc.core.presentation.IBaseView
import ru.terrakok.cicerone.Navigator

interface SplashContract {
    interface View : IBaseView

    interface Presenter : IBasePresenter {
        fun setNavigator(navigator: Navigator)
    }
}

package com.example.mc.feature.splash

import com.example.mc.core.presentation.IBasePresenter
import com.example.mc.core.presentation.IBaseView
import ru.terrakok.cicerone.Navigator

interface SplashContract {
    interface View : IBaseView

    interface Presenter: IBasePresenter {
        fun setNavigator(navigator: Navigator)
    }
}

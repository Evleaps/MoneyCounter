package com.example.mc.feature.splashScreen

import com.example.mc.core.presentation.BasePresenter
import com.example.mc.router.Screens
import org.koin.standalone.inject
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder

class SplashPresenter : BasePresenter<SplashContract.View>(), SplashContract.Presenter {

    private val navigatorHolder by inject<NavigatorHolder>()

    override fun onViewCreated() {
        router.newRootScreen(Screens.CounterFragment)
    }

    override fun setNavigator(navigator: Navigator) {
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}
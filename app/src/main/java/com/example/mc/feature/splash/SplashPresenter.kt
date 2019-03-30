package com.example.mc.feature.splash

import com.example.mc.core.presentation.BasePresenter
import com.example.mc.router.Screens
import org.koin.standalone.inject
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

class SplashPresenter : BasePresenter<SplashContract.View>(), SplashContract.Presenter {

    private val router by inject<Router>()
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
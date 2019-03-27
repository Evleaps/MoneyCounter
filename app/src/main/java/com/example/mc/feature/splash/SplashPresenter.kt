package com.example.mc.feature.splash

import com.example.mc.core.presentation.BasePresenter
import com.example.mc.core.router.IRouter

class SplashPresenter : BasePresenter<SplashContract.View, IRouter>(), SplashContract.Presenter {

    override fun onViewCreated() {
        router.navigateToRoot()
    }
}
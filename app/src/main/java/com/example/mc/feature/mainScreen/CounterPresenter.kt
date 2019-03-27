package com.example.mc.feature.mainScreen

import com.example.mc.core.presentation.BasePresenter
import com.example.mc.core.router.IRouter

class CounterPresenter : BasePresenter<CounterContract.View, IRouter>(), CounterContract.Presenter {

    override fun onViewCreated() {
        super.onViewCreated()
    }
}
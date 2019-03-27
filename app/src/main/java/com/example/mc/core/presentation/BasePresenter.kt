package com.example.mc.core.presentation

import com.example.mc.core.router.IRouter
import com.example.mc.core.router.Router
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject


abstract class BasePresenter<V : IBaseView, R : IRouter> : IBasePresenter, KoinComponent {
    protected var view: V? = null
    protected val router: Router by inject()

    override fun attachView(view: IBaseView) {
        this.view = view as V
    }

    override fun detachView() {
        this.view = null
    }

    override fun onBack() {
        router.back()
    }

    override fun onViewCreated() {}
}


package com.example.mc.core.presentation

import org.koin.standalone.KoinComponent
import org.koin.standalone.inject
import ru.terrakok.cicerone.Router


abstract class BasePresenter<V : IBaseView> : IBasePresenter, KoinComponent {
    protected var view: V? = null
    protected val router by inject<Router>()

    override fun attachView(view: IBaseView) {
        this.view = view as V
    }

    override fun detachView() {
        this.view = null
    }

    override fun onBack() {
        router.exit()
    }

    //LifeCycle Activity
    override fun onViewCreated() {}

    override fun onStarted() {}
    override fun onResumed() {}
    override fun onPause() {}
    override fun onStop() {}
    override fun onDestroy() {}

    //LifeCycle Activity
    override fun onResumeFragments() {}
}


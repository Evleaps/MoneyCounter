package com.example.mc.core.presentation

interface IBasePresenter : ILifeCycle {
    fun attachView(view: IBaseView)
    fun detachView()
    fun onBack()
}

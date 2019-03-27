package com.example.mc.core.presentation

interface IBasePresenter {
    fun attachView(view: IBaseView)
    fun detachView()
    fun onBack()
    fun onViewCreated()
}
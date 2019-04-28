package com.example.mc.feature.aboutScreen

import com.example.mc.core.presentation.BasePresenter

class AboutPresenter(private val version: String) : BasePresenter<AboutContract.View>(), AboutContract.Presenter {

    override fun onResumed() {
        super.onResumed()
        view?.displayApplicationVersion(version)
    }
}

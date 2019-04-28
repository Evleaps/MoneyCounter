package com.example.mc.feature.aboutScreen

import com.example.mc.core.presentation.IBasePresenter
import com.example.mc.core.presentation.IBaseView

interface AboutContract {

    interface View : IBaseView {
        fun displayApplicationVersion(version: String)
    }

    interface Presenter : IBasePresenter
}

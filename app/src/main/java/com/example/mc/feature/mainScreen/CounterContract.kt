package com.example.mc.feature.mainScreen

import com.example.mc.core.presentation.IBasePresenter
import com.example.mc.core.presentation.IBaseView

interface CounterContract {
    interface View : IBaseView {
        fun showTotal()
    }

    interface Presenter : IBasePresenter
}
package com.example.mc.core.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<P : IBasePresenter>: AppCompatActivity(), IBaseView {

    protected abstract val presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }
}
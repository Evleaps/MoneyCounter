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

    override fun onStart() {
        super.onStart()
        presenter.onStarted()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResumed()
    }

    override fun onPause() {
        presenter.onPause()
        super.onPause()
    }

    override fun onStop() {
        presenter.onStop()
        super.onStop()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        presenter.detachView()
        super.onDestroy()
    }
}
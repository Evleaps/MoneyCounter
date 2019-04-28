package com.example.mc.core.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<P : IBasePresenter> : AppCompatActivity(), IBaseView {

    protected abstract val presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResource())
        presenter.attachView(this)
        presenter.onViewCreated()
    }

    /**
     * @return resource id for activity's layout
     */
    private fun getLayoutResource(): Int {
        return this.javaClass.getAnnotation(Layout::class.java)?.layoutRes
            ?: throw AssertionError("Layout for the activity ${this.javaClass.simpleName} wasn't declared")
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

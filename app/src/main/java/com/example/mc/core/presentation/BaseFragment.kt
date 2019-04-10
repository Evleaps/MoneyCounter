package com.example.mc.core.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment<P : IBasePresenter> : IBaseView, Fragment()  {
    protected abstract val presenter: P

    /**
     * @return resource id for activity's layout
     */
    private fun getLayoutResource(): Int {
        val layout = this.javaClass.getAnnotation(Layout::class.java)
        if (layout == null || layout.layoutRes == 0) {
            throw AssertionError("Layout for fragment ${this.javaClass.simpleName} wasn't declared")
        }
        return layout.layoutRes
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutResource(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
package com.example.mc.core.presentation

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mc.R

abstract class BaseFragment<P : IBasePresenter> : IBaseView, Fragment() {
    protected abstract val presenter: P

    /**
     * @return resource id for activity's layout
     */
    private fun getLayoutResource(): Int {
        return this.javaClass.getAnnotation(Layout::class.java)?.layoutRes
            ?: throw AssertionError("Layout for the activity ${this.javaClass.simpleName} wasn't declared")
    }

    /**
     * @return resource id of color for change status bar
     */
    private fun getStatusBarColorResource() = this.javaClass.getAnnotation(StatusBarColor::class.java)?.styleRes ?: getDefaultStatusBarColor()

    private fun getDefaultStatusBarColor(): Int {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            context?.getColor(R.color.orange1) ?: Color.TRANSPARENT
        } else {
            Color.TRANSPARENT
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = activity?.window
            window?.statusBarColor = getStatusBarColorResource()
        }
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

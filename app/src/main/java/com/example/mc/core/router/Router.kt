package com.example.mc.core.router

import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.mc.R
import com.example.mc.common.LOG_PREFIX
import com.example.mc.feature.mainScreen.CounterFragment

class Router(private val fragmentManager: FragmentManager) : IRouter {

    init {
        Log.d(TAG, "Instance Router")
    }

    companion object {
        private val TAG = LOG_PREFIX + Router::class.java.simpleName
        const val COUNTER_FRAGMENT = "CounterFragment"
    }

    override fun add(fragmentId: String) {
        val transaction = fragmentManager?.beginTransaction()
        val fragm = getFragment(fragmentId)

        if (fragmentManager?.findFragmentByTag(fragm.tag) == null) {
            transaction?.add(R.id.splash_container, fragm, fragm.tag)
            transaction?.commit()
        }
    }

    override fun navigateToRoot() {
        add(COUNTER_FRAGMENT)
    }

    override fun back() {
        fragmentManager?.popBackStack()
    }

    override fun navigateTo(fragmentId: String) {
        val transaction = fragmentManager?.beginTransaction()
        val fragm = getFragment(fragmentId)

        if (fragmentManager?.findFragmentByTag(fragm.tag) == null) {
            transaction?.replace(R.id.splash_container, fragm, fragm.tag)
            transaction?.addToBackStack(fragmentId)
            transaction?.commit()
        }
    }

    override fun replace(fragmentId: String) {
        val transaction = fragmentManager?.beginTransaction()
        val fragm = getFragment(fragmentId)
        if (fragmentManager?.findFragmentByTag(fragm.tag) == null) {
            transaction?.replace(R.id.splash_container, fragm, fragm.tag)
            transaction?.commit()
        }
    }

    override fun remove(fragmentId: String) {
        val transaction = fragmentManager?.beginTransaction()
        val fragm = getFragment(fragmentId)
        if (fragmentManager?.findFragmentByTag(fragm.tag) != null) {
            transaction?.remove(fragm)
            transaction?.commit()
        }
    }

    override fun getTransaction(): FragmentTransaction? {
        return fragmentManager?.beginTransaction()
    }


    private fun getFragment(fragment: String) = when (fragment) {
        COUNTER_FRAGMENT -> CounterFragment()
        else -> CounterFragment()
    }
}

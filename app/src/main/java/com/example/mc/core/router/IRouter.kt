package com.example.mc.core.router

import androidx.fragment.app.FragmentTransaction

interface IRouter {

    companion object {
        const val COUNTER_FRAGMENT = "counter_fragment"
    }

    fun navigateTo(fragmentId: String)

    fun navigateToRoot()

    fun add(fragmentId: String)

    fun back()

    fun replace(fragmentId: String)

    fun remove(fragmentId: String)

    fun getTransaction(): FragmentTransaction?
}
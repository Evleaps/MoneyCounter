package com.example.mc.core.presentation

interface ILifeCycle {

    fun onViewCreated()
    fun onStarted()
    fun onResumed()

    fun onPause()
    fun onStop()
    fun onDestroy()

    fun onResumeFragments()
}
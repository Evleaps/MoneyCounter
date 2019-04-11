package com.example.mc.core.presentation

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FILE, AnnotationTarget.CLASS)
annotation class Layout(val layoutRes: Int = 0)

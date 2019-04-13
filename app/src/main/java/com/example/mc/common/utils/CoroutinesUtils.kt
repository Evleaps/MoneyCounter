package com.example.mc.common.utils

import kotlinx.coroutines.*

fun launchIO(run: suspend () -> Unit): Job {
    return GlobalScope.launch(Dispatchers.IO) { run() }
}

fun launchMain(run: suspend () -> Unit): Job {
    return GlobalScope.launch(Dispatchers.Main) { run() }
}

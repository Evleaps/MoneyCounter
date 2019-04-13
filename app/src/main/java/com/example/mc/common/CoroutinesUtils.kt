package com.example.mc.common

import kotlinx.coroutines.*

fun launchIO(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    run: suspend () -> Unit
): Job {
    return GlobalScope.launch(dispatcher) { run() }
}

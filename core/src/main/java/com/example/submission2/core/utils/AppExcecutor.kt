package com.example.submission2.core.utils

import android.os.Handler
import android.os.Looper
import androidx.annotation.VisibleForTesting
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AppExcecutor @VisibleForTesting constructor(
    private val diskIo: Executor,
    private val networkIO: Executor,
    private val mainThread: Executor

) {

    companion object {
        private const val THREAD_CNT = 3
    }

    constructor() : this(
        Executors.newSingleThreadExecutor(),
        Executors.newFixedThreadPool(THREAD_CNT),
        MainThreadExecutor()
    )

    fun diskIO(): Executor = diskIo

    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}
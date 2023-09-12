package com.example.presentation.generic

import android.annotation.SuppressLint
import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers

@SuppressLint("RestrictedApi")
class AndroidAppTestRunner(testClass: Class<*>) : AppTestRunner(testClass) {

    private val taskExecutor = object : TaskExecutor() {

        override fun executeOnDiskIO(runnable: Runnable) = runnable.run()
        override fun postToMainThread(runnable: Runnable) = runnable.run()
        override fun isMainThread(): Boolean = true
    }

    init {
        ArchTaskExecutor.getInstance().setDelegate(taskExecutor)
        RxAndroidPlugins.setMainThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }
}
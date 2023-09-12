package com.example.presentation.generic

import android.annotation.SuppressLint
import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers

/**
 * Custom test runner that remaps Rx schedulers to trampoline, for testing purposes.
 */
@SuppressLint("RestrictedApi")
class AppRxMockitoJUnitRunner(classUnderTest: Class<*>) : RxMockitoJUnitRunner(classUnderTest) {

    init {
        RxAndroidPlugins.reset()
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        ArchTaskExecutor.getInstance().setDelegate(
            object : TaskExecutor() {
                override fun executeOnDiskIO(runnable: Runnable) = runnable.run()

                override fun postToMainThread(runnable: Runnable) = runnable.run()

                override fun isMainThread(): Boolean = true
            }
        )
    }
}
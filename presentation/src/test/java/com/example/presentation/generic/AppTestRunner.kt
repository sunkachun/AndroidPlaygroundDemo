package com.example.presentation.generic

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.unmockkStatic
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.runner.notification.RunNotifier
import org.junit.runners.BlockJUnit4ClassRunner
import org.junit.runners.model.FrameworkMethod

@OptIn(ExperimentalCoroutinesApi::class)
open class AppTestRunner(testClass: Class<*>) : BlockJUnit4ClassRunner(testClass) {

    private val testDispatcher = UnconfinedTestDispatcher()

    init {
        RxJavaPlugins.reset()
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
    }

    override fun runChild(method: FrameworkMethod?, notifier: RunNotifier?) {
        Dispatchers.setMain(testDispatcher)
        mockkStatic(Dispatchers::class)
        every { Dispatchers.Main } answers { callOriginal() }
        every { Dispatchers.IO } answers { testDispatcher }
        every { Dispatchers.Unconfined } answers { testDispatcher }
        every { Dispatchers.Default } answers { testDispatcher }

        super.runChild(method, notifier)

        unmockkStatic(Dispatchers::class)
        Dispatchers.resetMain()
    }

    override fun createTest(): Any {
        return super.createTest().also {
            MockKAnnotations.init(it)
        }
    }
}
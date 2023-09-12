package com.example.presentation.generic

import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.mockito.junit.MockitoJUnitRunner

/**
 * Custom test runner that remaps Rx schedulers to trampoline, for testing purposes.
 */
open class RxMockitoJUnitRunner(classUnderTest: Class<*>) : MockitoJUnitRunner.Silent(classUnderTest) {

    init {
        RxJavaPlugins.reset()
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
    }
}
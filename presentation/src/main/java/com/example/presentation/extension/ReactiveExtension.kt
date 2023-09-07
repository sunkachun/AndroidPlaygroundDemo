package com.example.presentation.extension

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Convenience method to subscribe a Maybe to an IO thread
 */
fun <T> Maybe<T>.subscribeOnIO() = subscribeOn(Schedulers.io())

/**
 * Convenience method to subscribe a Maybe to an IO thread
 */
fun <T> Maybe<T>.observeOnMain() = observeOn(AndroidSchedulers.mainThread())

/**
 * Convenience method to subscribe an Observable to an IO thread
 */
fun <T> Observable<T>.subscribeOnIO() = subscribeOn(Schedulers.io())

/**
 * Convenience method to observe an Observable on the main thread
 */
fun <T> Observable<T>.observeOnMain() = observeOn(AndroidSchedulers.mainThread())

/**
 * Convenience method to subscribe a Flowable to an IO thread
 */
fun <T> Flowable<T>.subscribeOnIO() = subscribeOn(Schedulers.io())

/**
 * Convenience method to observe a Flowable on the main thread
 */
fun <T> Flowable<T>.observeOnMain() = observeOn(AndroidSchedulers.mainThread())

/**
 * Convenience method to subscribe a Single to an IO thread
 */
fun <T> Single<T>.subscribeOnIO() = subscribeOn(Schedulers.io())

/**
 * Convenience method to observe a Single on the main thread
 */
fun <T> Single<T>.observeOnMain() = observeOn(AndroidSchedulers.mainThread())

/**
 * Convenience method to subscribe a Completable to an IO thread
 */
fun Completable.subscribeOnIO() = subscribeOn(Schedulers.io())

/**
 * Convenience method to observe a Completable on the main thread
 */
fun Completable.observeOnMain() = observeOn(AndroidSchedulers.mainThread())
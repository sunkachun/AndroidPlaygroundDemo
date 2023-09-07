package com.example.data.util

import retrofit2.Response

val <T : Any> Response<T>.requireData: T
    get() = checkNotNull(body()) { "Response data was expected but got null" }
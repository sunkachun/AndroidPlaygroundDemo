package com.example.data.network.client

import okhttp3.OkHttpClient

interface OkHttpClientProvider {

    val client: OkHttpClient
}
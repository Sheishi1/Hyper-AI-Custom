package com.hyper.customai.data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine

expect fun createHttpClient(engine: HttpClientEngine): HttpClient
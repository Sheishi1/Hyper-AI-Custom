package com.hyper.customai.di.modules

import com.hyper.customai.data.network.createHttpClient
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.dsl.module

actual val platformHttpClientModule = module {
    single {
        createHttpClient(engine = OkHttp.create())
    }
}
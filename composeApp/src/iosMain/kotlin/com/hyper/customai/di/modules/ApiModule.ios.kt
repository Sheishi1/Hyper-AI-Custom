package com.hyper.customai.di.modules

import com.hyper.customai.data.network.createHttpClient
import io.ktor.client.engine.darwin.Darwin
import org.koin.dsl.module

actual val platformHttpClientModule = module {
    single {
        createHttpClient(engine = Darwin.create())
    }
}
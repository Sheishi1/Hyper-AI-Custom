package com.hyper.customai.di.modules

import com.hyper.customai.data.createHttpClient
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformHttpClientModule = module {
    single {
        createHttpClient(engine = Darwin.create())
    }
}
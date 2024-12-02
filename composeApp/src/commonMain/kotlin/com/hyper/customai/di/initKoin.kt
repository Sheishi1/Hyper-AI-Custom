package com.hyper.customai.di

import com.hyper.customai.di.modules.apiModule
import com.hyper.customai.di.modules.platformHttpClientModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            platformHttpClientModule,
            apiModule
        )
    }
}
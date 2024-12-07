package com.hyper.customai.di.modules

import com.hyper.customai.data.dataStore.createDataStorePlatform
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformDataStoreModule = module {
    single { createDataStorePlatform() }
}
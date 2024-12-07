package com.hyper.customai.di.modules

import com.hyper.customai.data.dataStore.createDataStorePlatform
import com.hyper.customai.domain.repository.UserDataStoreRepository
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

actual val platformDataStoreModule: Module = module {
    single { createDataStorePlatform() }
}
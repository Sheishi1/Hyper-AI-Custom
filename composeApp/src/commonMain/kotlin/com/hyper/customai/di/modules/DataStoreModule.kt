package com.hyper.customai.di.modules

import com.hyper.customai.data.repository.UserDataStoreRepositoryImpl
import com.hyper.customai.domain.repository.UserDataStoreRepository
import com.hyper.customai.domain.useCase.dataStoreUseCases.UserDataStoreUseCase
import com.hyper.customai.presentation.viewModels.AuthScreenViewModel
import com.hyper.customai.presentation.viewModels.MainScreenViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformDataStoreModule: Module

val dataStoreModule = module {
    single<UserDataStoreRepository> { UserDataStoreRepositoryImpl(get()) }.bind<UserDataStoreRepository>()
    single { UserDataStoreUseCase(get()) }
    singleOf(::AuthScreenViewModel)
    singleOf(::MainScreenViewModel)
}

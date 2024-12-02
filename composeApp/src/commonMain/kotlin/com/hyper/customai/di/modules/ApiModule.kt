package com.hyper.customai.di.modules

import com.hyper.customai.data.repository.GeminiApiRepositoryImpl
import com.hyper.customai.domain.repository.GeminiApiRepository
import com.hyper.customai.domain.useCase.getGeminiMessage.GetGeminiMessageUseCase
import com.hyper.customai.presentation.viewModels.MainScreenViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformHttpClientModule: Module

val apiModule = module {
    single<GeminiApiRepository> { GeminiApiRepositoryImpl(get()) }.bind<GeminiApiRepository>()
    single { GetGeminiMessageUseCase(get()) }

    singleOf(::MainScreenViewModel)
}


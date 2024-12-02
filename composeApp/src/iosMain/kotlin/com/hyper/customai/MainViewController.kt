package com.hyper.customai

import androidx.compose.ui.window.ComposeUIViewController
import com.hyper.customai.di.initKoin
import com.hyper.customai.presentation.App

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }
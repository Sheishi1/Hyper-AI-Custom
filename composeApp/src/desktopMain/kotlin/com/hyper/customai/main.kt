package com.hyper.customai

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.hyper.customai.di.initKoin
import com.hyper.customai.presentation.App

fun main() = application {
    initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "HyperAI",
    ) {
        App()
    }
}
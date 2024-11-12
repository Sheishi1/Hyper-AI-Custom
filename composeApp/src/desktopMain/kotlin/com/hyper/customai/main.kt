package com.hyper.customai

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.hyper.customai.presentation.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "HyperAI_Custom",
    ) {
        App()
    }
}
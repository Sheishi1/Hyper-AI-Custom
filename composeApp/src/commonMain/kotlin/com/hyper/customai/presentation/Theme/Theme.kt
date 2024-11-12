package com.hyper.customai.presentation.Theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColors(
    primary = primaryDark,
    primaryVariant = primaryVariantDark,
    background = backgroundDark,
    surface = surfaceDark,
    onPrimary = onPrimaryDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    onBackground = onBackgroundDark,
    onSurface = onSurfaceDark,
    error = errorDark,
    onError = onErrorDark
)

@Composable
fun HyperAiTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = DarkColorScheme,
        typography = Typography(),
        content = content
    )
}
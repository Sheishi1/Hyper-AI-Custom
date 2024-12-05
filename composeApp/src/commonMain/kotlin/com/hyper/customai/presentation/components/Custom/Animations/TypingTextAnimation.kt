package com.hyper.customai.presentation.components.Custom.Animations

import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import kotlinx.coroutines.delay

@Composable
fun TypingTextAnimation(
    modifier: Modifier,
    animate: Boolean = true,
    text: AnnotatedString,
    textStyle: TextStyle,
    durationMs: Long,
    onAnimationProgress: (progress: Float) -> Unit = {},
    onAnimationFinish: () -> Unit = {}
) {
    var animatedText by remember { mutableStateOf(AnnotatedString("")) }

    if (animate) {
        LaunchedEffect(Unit) {
            var index = 0

            while (animatedText.length < text.length) {
                animatedText += AnnotatedString(text[index].toString())
                onAnimationProgress((animatedText.length.toFloat() / text.length).coerceIn(0f, 1f))
                index++
                delay(durationMs)
            }
            onAnimationFinish()
        }
    }

    SelectionContainer {
        Text(
            modifier = modifier,
            text = if (animate) animatedText else text,
            style = textStyle
        )
    }
}
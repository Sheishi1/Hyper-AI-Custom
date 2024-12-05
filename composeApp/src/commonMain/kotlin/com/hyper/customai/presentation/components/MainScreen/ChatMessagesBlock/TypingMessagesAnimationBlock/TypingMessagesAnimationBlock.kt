package com.hyper.customai.presentation.components.MainScreen.ChatMessagesBlock.TypingMessagesAnimationBlock

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hyper.customai.presentation.components.Custom.Animations.TypingTextAnimation
import hyperai_custom.composeapp.generated.resources.Res
import hyperai_custom.composeapp.generated.resources.lets_start_messaging
import org.jetbrains.compose.resources.stringResource

@Composable
fun TypingMessagesAnimationBlock(modifier: Modifier) {
    var visible by remember { mutableStateOf(false) }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        TypingTextAnimation(
            modifier = modifier,
            text = AnnotatedString(stringResource(Res.string.lets_start_messaging)),
            textStyle = TextStyle(
                color = MaterialTheme.colors.onBackground,
                fontSize = 32.sp,
            ),
            durationMs = 150L,
            onAnimationFinish = {
                visible = true
            }
        )

        AnimatedVisibility(
            visible = visible
        ) {
            Text(
                text = ":)",
                style =  TextStyle(
                    color = MaterialTheme.colors.primary,
                    fontSize = 32.sp,
                )
            )
        }
    }
}
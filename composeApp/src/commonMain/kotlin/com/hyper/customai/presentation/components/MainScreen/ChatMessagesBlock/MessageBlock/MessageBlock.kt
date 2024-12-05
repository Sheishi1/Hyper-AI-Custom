package com.hyper.customai.presentation.components.MainScreen.ChatMessagesBlock.MessageBlock

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hyper.customai.presentation.components.Custom.Animations.TypingTextAnimation
import com.hyper.customai.presentation.components.Custom.Avatars.AvatarByResId
import org.jetbrains.compose.resources.DrawableResource

@Composable
fun MessageBlock(
    modifier: Modifier,
    resDrawable: DrawableResource,
    text: AnnotatedString,
    animateText: Boolean = false,
    animationProgress: (progress: Float) -> Unit = {}
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = if (text.lines().size == 1) Alignment.CenterVertically else Alignment.Top
    ) {
        AvatarByResId(resId = resDrawable)

        TypingTextAnimation(
            modifier = Modifier,
            animate = animateText,
            text = text,
            textStyle = TextStyle(
                color = MaterialTheme.colors.onBackground,
                fontSize = 16.sp,
            ),
            durationMs = 10,
            onAnimationProgress = animationProgress
        )
    }
}
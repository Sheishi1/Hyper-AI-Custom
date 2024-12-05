package com.hyper.customai.presentation.components.MainScreen.ChatMessagesBlock

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.hyper.customai.presentation.components.Custom.Animations.TypingTextAnimation
import com.hyper.customai.presentation.components.MainScreen.ChatMessagesBlock.MessageBlock.MessageBlock
import com.hyper.customai.presentation.components.MainScreen.ChatMessagesBlock.TypingMessagesAnimationBlock.TypingMessagesAnimationBlock
import com.hyper.customai.presentation.utils.HandleUiState
import com.hyper.customai.presentation.utils.formatedGeminiText
import hyperai_custom.composeapp.generated.resources.Res
import hyperai_custom.composeapp.generated.resources.ic_launcher_foreground
import hyperai_custom.composeapp.generated.resources.person_24dp_e8eaed

@Composable
fun ChatMessagesBlock(
    modifier: Modifier,
    textFieldValue: String,
    geminiMessage: String,
    onAnimationProgress: (progress: Float) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        MessageBlock(
            modifier = Modifier,
            resDrawable = Res.drawable.person_24dp_e8eaed,
            text = AnnotatedString(textFieldValue)
        )

        MessageBlock(
            modifier = Modifier,
            animateText = true,
            resDrawable = Res.drawable.ic_launcher_foreground,
            text = formatedGeminiText(geminiMessage.trimEnd()),
            animationProgress = onAnimationProgress
        )
    }
}
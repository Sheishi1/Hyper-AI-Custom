package com.hyper.customai.presentation.components.MainScreen.Navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hyperai_custom.composeapp.generated.resources.Res
import hyperai_custom.composeapp.generated.resources.characters
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource

@Composable
fun ChatTextFieldBlock(
    modifier: Modifier,
    animationProgress: Float,
    animationProgressColor: Color = MaterialTheme.colors.primary,
    value: String,
    onValueChange: (newValue: String) -> Unit,
    onTrailingIconClick: () -> Unit
) {
    var textFieldFocused by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .drawWithContent {
                drawContent()

                drawLine(
                    color = Color.DarkGray,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = 2.dp.toPx()
                )

                drawLine(
                    color = animationProgressColor,
                    start = Offset(0f, 0f),
                    end = Offset(animationProgress * size.width, 0f),
                    strokeWidth = 2.dp.toPx()
                )
            }
            .background(MaterialTheme.colors.background)
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End,
        ) {
            AnimatedVisibility(
                visible = textFieldFocused
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 12.dp),
                    text = "${value.length} " + stringResource(Res.string.characters).lowercase(),
                    color = MaterialTheme.colors.onBackground,
                    fontSize = 14.sp
                )
            }

            ChatTextField(
                modifier = Modifier.fillMaxWidth(),
                value = value,
                onFocusChanged = { focus ->
                    textFieldFocused = focus
                },
                onValueChange = { newValue ->
                    onValueChange(newValue)
                },
                onTrailingIconClick = {
                    onTrailingIconClick()
                }
            )
        }
    }
}
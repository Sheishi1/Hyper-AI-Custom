package com.hyper.customai.presentation.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.P
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.hyper.customai.common.Resource
import com.hyper.customai.presentation.components.Custom.Animations.TypingTextAnimation
import com.hyper.customai.presentation.components.MainScreen.ChatMessagesBlock.ChatMessagesBlock
import com.hyper.customai.presentation.components.MainScreen.ChatMessagesBlock.TypingMessagesAnimationBlock.TypingMessagesAnimationBlock
import com.hyper.customai.presentation.components.MainScreen.Navigation.ChatTextField
import com.hyper.customai.presentation.components.MainScreen.Navigation.ChatTextFieldBlock
import com.hyper.customai.presentation.utils.HandleUiState
import com.hyper.customai.presentation.utils.keyboardAsState
import com.hyper.customai.presentation.viewModels.MainScreenViewModel
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    modifier: Modifier,
    navController: NavHostController,
    mainScreenViewModel: MainScreenViewModel
) {
    var textFieldValue by remember { mutableStateOf("") }
    var userMessage by remember { mutableStateOf("") }
    var animationProgress by remember { mutableStateOf(0f) }
    val geminiMessage by mainScreenViewModel.geminiMessage.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current

    Scaffold(
        modifier = Modifier.windowInsetsPadding(WindowInsets.systemBars),
        bottomBar = {
            ChatTextFieldBlock(
                modifier = Modifier.fillMaxWidth(),
                animationProgress = animationProgress,
                value = textFieldValue,
                onValueChange = { newValue ->
                    textFieldValue = newValue
                },
                onTrailingIconClick = {
                    coroutineScope.launch {
                        mainScreenViewModel.getResponse(value = textFieldValue)
                        userMessage = textFieldValue
                        textFieldValue = ""
                        animationProgress = 0f
                        focusManager.clearFocus()
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = modifier.fillMaxSize()
        ) {
            when (val state = geminiMessage) {
                is HandleUiState.None -> {
                    TypingMessagesAnimationBlock(modifier = Modifier.align(Alignment.Center))
                }

                is HandleUiState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }

                is HandleUiState.Success -> {
                    LazyColumn(
                        modifier = modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        contentPadding = PaddingValues(
                            top = 10.dp,
                            bottom = innerPadding.calculateBottomPadding(),
                            start = 10.dp,
                            end = 10.dp
                        )
                    ) {
                        item {
                            ChatMessagesBlock(
                                modifier = Modifier.fillMaxSize(),
                                textFieldValue = userMessage,
                                geminiMessage = state.data,
                                onAnimationProgress = { progress ->
                                    animationProgress = progress
                                }
                            )
                        }
                    }
                }

                is HandleUiState.Error -> {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = state.message,
                        color = MaterialTheme.colors.error,
                        fontSize = 18.sp,
                    )
                }
            }
        }
    }
}
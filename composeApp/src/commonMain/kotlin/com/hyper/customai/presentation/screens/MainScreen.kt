package com.hyper.customai.presentation.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.P
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hyper.customai.common.Resource
import com.hyper.customai.presentation.components.MainScreen.Navigation.ChatTextField
import com.hyper.customai.presentation.viewModels.MainScreenViewModel
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    modifier: Modifier,
    navController: NavHostController,
    mainScreenViewModel: MainScreenViewModel
) {
    var textFieldValue by remember { mutableStateOf("") }
    val geminiMessage by mainScreenViewModel.geminiMessage.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        bottomBar = {
            ChatTextField(
                modifier = Modifier.fillMaxWidth(),
                value = textFieldValue,
                onValueChange = { newValue ->
                    textFieldValue = newValue
                },
                onTrailingIconClick = {
                    coroutineScope.launch {
                        mainScreenViewModel.getResponse(value = textFieldValue)
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .windowInsetsPadding(WindowInsets.safeDrawing)
                .padding(bottom = innerPadding.calculateBottomPadding(), start = 20.dp, end = 20.dp),
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                item {
                    when (val state = geminiMessage) {
                        is Resource.Success -> {
                            AnimatedVisibility(
                                visible = true
                            ) {
                                Text(
                                    text = state.data,
                                    color = MaterialTheme.colors.onBackground
                                )
                            }
                        }

                        is Resource.Loading -> {
                            CircularProgressIndicator()
                        }

                        is Resource.Error -> {
                            Text(
                                text = "Произошлка ошибка!\n${state.message}",
                                color = MaterialTheme.colors.onBackground
                            )
                        }
                    }
                }
            }
        }
    }
}
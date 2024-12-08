package com.hyper.customai.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hyper.customai.presentation.Theme.HyperAiTheme
import com.hyper.customai.presentation.screens.AuthScreen
import com.hyper.customai.presentation.screens.MainScreen
import com.hyper.customai.presentation.viewModels.AuthScreenViewModel
import com.hyper.customai.presentation.viewModels.MainScreenViewModel
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
fun App(
    navController: NavHostController = rememberNavController()
) {
    HyperAiTheme {
        KoinContext {
            val mainScreenViewModel = koinViewModel<MainScreenViewModel>()
            val authScreenViewModel = koinViewModel<AuthScreenViewModel>()
            val startDestination =
                if (authScreenViewModel.apiToken != "") "MainScreen" else "AuthScreen"

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
            ) {
                if (authScreenViewModel.apiToken != null) {
                    NavHost(
                        navController = navController,
                        startDestination = startDestination
                    ) {
                        composable(route = "AuthScreen") {
                            AuthScreen(
                                modifier = Modifier,
                                navController = navController,
                                authScreenViewModel = authScreenViewModel
                            )
                        }

                        composable(route = "MainScreen") {
                            MainScreen(
                                modifier = Modifier,
                                navController = navController,
                                mainScreenViewModel = mainScreenViewModel,
                                authScreenViewModel = authScreenViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}
package com.hyper.customai.presentation

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hyper.customai.presentation.Theme.HyperAiTheme
import com.hyper.customai.presentation.screens.AuthScreen
import com.hyper.customai.presentation.screens.MainScreen
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

            NavHost(
                navController = navController,
                startDestination = "AuthScreen"
            ) {
                composable(route = "AuthScreen") {
                    AuthScreen(
                        modifier = Modifier,
                        navController = navController
                    )
                }

                composable(route = "MainScreen") {
                    MainScreen(
                        modifier = Modifier,
                        navController = navController,
                        mainScreenViewModel = mainScreenViewModel
                    )
                }
            }
        }
    }
}
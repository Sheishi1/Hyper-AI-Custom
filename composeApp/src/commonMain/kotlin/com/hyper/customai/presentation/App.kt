package com.hyper.customai.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hyper.customai.presentation.Theme.HyperAiTheme
import com.hyper.customai.presentation.screens.AuthScreen
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import hyperai_custom.composeapp.generated.resources.Res
import hyperai_custom.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App(
    navController: NavHostController = rememberNavController()
) {
    HyperAiTheme {
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
        }
    }
}
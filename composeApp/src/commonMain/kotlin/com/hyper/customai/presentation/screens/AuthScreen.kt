package com.hyper.customai.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.hyper.customai.presentation.components.Custom.Buttons.PrimaryGradientButton
import com.hyper.customai.presentation.viewModels.AuthScreenViewModel
import hyperai_custom.composeapp.generated.resources.Res
import hyperai_custom.composeapp.generated.resources.empty_textfield
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun AuthScreen(
    modifier: Modifier,
    navController: NavHostController,
    authScreenViewModel: AuthScreenViewModel
) {
    var textFiledValue by remember { mutableStateOf("") }
    val primaryColor = MaterialTheme.colors.primary
    val secondaryColor = MaterialTheme.colors.secondary
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val emptyTextFieldText = stringResource(Res.string.empty_textfield)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .drawBehind {
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(primaryColor.copy(alpha = 0.2f), primaryColor.copy(alpha = 0.1f), primaryColor.copy(alpha = 0.05f), primaryColor.copy(alpha = 0.025f), primaryColor.copy(alpha = 0f)),
                        center = Offset(0f, 0f),
                        radius = 800f
                    ),
                    radius = 600f,
                    center = Offset(0f, 0f)
                )
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(secondaryColor.copy(alpha = 0.2f), secondaryColor.copy(alpha = 0.1f), secondaryColor.copy(alpha = 0.05f), secondaryColor.copy(alpha = 0.025f), secondaryColor.copy(alpha = 0f)),
                        center = Offset(size.width, size.height),
                        radius = 800f
                    ),
                    radius = 600f,
                    center = Offset(size.width, size.height)
                )
            }
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.width(392.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "Авторизация",
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onBackground,
                fontSize = 32.sp
            )
            Spacer(modifier = Modifier.height(30.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                value = textFiledValue,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = MaterialTheme.colors.onBackground
                ),
                placeholder = { Text("Токен") },
                onValueChange = { newValue ->
                    textFiledValue = newValue
                }
            )

            PrimaryGradientButton(
                modifier = Modifier.width(392.dp),
                text = "Продолжить"
            ) {
                if (textFiledValue.isEmpty() || textFiledValue == "") {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(message = emptyTextFieldText)
                    }
                } else {
                    authScreenViewModel.saveApiToken(textFiledValue)
                    navController.navigate("MainScreen")
                }
            }
        }

        SnackbarHost(
            modifier = Modifier.align(Alignment.BottomCenter),
            hostState = snackbarHostState
        )
    }
}
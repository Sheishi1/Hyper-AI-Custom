package com.hyper.customai.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AuthScreen(
    modifier: Modifier,
) {
    var textFiledValue by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = textFiledValue,
            placeholder = { Text("Токен") },
            onValueChange = { newValue ->
                textFiledValue = newValue
            }
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {

            }
        ) {
            Text("Продолжить")
        }
    }
}
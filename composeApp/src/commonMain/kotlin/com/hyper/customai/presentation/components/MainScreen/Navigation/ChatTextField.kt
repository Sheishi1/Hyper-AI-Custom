package com.hyper.customai.presentation.components.MainScreen.Navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DrawerDefaults.shape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import hyperai_custom.composeapp.generated.resources.Res
import hyperai_custom.composeapp.generated.resources.send_24px
import hyperai_custom.composeapp.generated.resources.send_message
import hyperai_custom.composeapp.generated.resources.write_message
import kotlinx.coroutines.NonCancellable.isActive
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ChatTextField(
    modifier: Modifier,
    value: String,
    onFocusChanged: (focus: Boolean) -> Unit,
    onValueChange: (newValue: String) -> Unit,
    maxLines: Int = 5,
    onTrailingIconClick: () -> Unit
) {
    val shape = if (value.lines().size <= 1) RoundedCornerShape(100) else RoundedCornerShape(10.dp)

    OutlinedTextField(
        modifier = modifier
            .onFocusChanged {
                onFocusChanged(it.isFocused)
            },
        value = value,
        onValueChange = { newValue ->
            onValueChange(newValue)
        },
        placeholder = {
            Text(text = stringResource(Res.string.write_message))
        },
        shape = shape,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = MaterialTheme.colors.onSecondary,
            disabledBorderColor = Color.DarkGray,
            focusedBorderColor = Color.DarkGray,
            unfocusedBorderColor = Color.DarkGray
        ),
        trailingIcon = {
            IconButton(
                onClick = {
                    onTrailingIconClick()
                }
            ) {
                Icon(
                    painter = painterResource(Res.drawable.send_24px),
                    tint = MaterialTheme.colors.onSecondary,
                    contentDescription = stringResource(Res.string.send_message)
                )
            }
        },
        maxLines = maxLines
    )
}
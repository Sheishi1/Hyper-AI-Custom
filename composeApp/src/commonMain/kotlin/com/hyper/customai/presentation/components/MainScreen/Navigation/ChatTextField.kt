package com.hyper.customai.presentation.components.MainScreen.Navigation

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import hyperai_custom.composeapp.generated.resources.Res
import hyperai_custom.composeapp.generated.resources.send_24px
import hyperai_custom.composeapp.generated.resources.send_message
import hyperai_custom.composeapp.generated.resources.write_message
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun ChatTextField(
    modifier: Modifier,
    shape: Shape = RoundedCornerShape(100),
    value: String,
    onValueChange: (newValue: String) -> Unit,
    onTrailingIconClick: () -> Unit
) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = { newValue ->
            onValueChange(newValue)
        },
        placeholder = {
            Text(text = stringResource(Res.string.write_message))
        },
        shape = shape,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.secondary,
            textColor = MaterialTheme.colors.onSecondary,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
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
        }
    )
}
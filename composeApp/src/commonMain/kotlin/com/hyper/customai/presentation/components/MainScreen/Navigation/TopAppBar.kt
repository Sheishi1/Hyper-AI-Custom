package com.hyper.customai.presentation.components.MainScreen.Navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.M
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import hyperai_custom.composeapp.generated.resources.Res
import hyperai_custom.composeapp.generated.resources.logout_24dp_e8eaed_fill0_wght400_grad0_opsz24
import org.jetbrains.compose.resources.painterResource

@Composable
fun TopAppBar(
    modifier: Modifier,
    onLogOut: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 20.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        IconButton(
            onClick = {
                onLogOut()
            }
        ) {
            Icon(
                painter = painterResource(Res.drawable.logout_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                contentDescription = "logout",
                tint = MaterialTheme.colors.error
            )
        }
    }
}
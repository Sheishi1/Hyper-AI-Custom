package com.hyper.customai.presentation.components.MainScreen.Navigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.M
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import hyperai_custom.composeapp.generated.resources.Res
import hyperai_custom.composeapp.generated.resources.logout_24dp_e8eaed_fill0_wght400_grad0_opsz24
import org.jetbrains.compose.resources.painterResource

@Composable
fun TopAppBar(
    modifier: Modifier,
    lazyListState: LazyListState,
    userRequestText: String,
    onLogOut: () -> Unit
) {
    val animateBgColor by animateColorAsState(
        targetValue = if (lazyListState.firstVisibleItemScrollOffset > 0) Color.DarkGray else Color.Transparent,
        animationSpec = tween(300)
    )
    val animateTextAlpha by animateFloatAsState(
        targetValue = if (lazyListState.firstVisibleItemScrollOffset > 0) 1f else 0f,
        animationSpec = tween(300)
    )

    Row (
        modifier = modifier
            .fillMaxWidth()
            .background(animateBgColor)
            .padding(start = 10.dp, end = 10.dp, top = WindowInsets.systemBars.getTop(LocalDensity.current).dp / 2, bottom = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(Res.drawable.logout_24dp_e8eaed_fill0_wght400_grad0_opsz24),
            contentDescription = null,
            tint = Color.Transparent
        )

        if (lazyListState.firstVisibleItemScrollOffset > 0) {
            Text(
                modifier = Modifier.weight(1f).alpha(animateTextAlpha),
                text = userRequestText,
                color = MaterialTheme.colors.onBackground,
                fontWeight = FontWeight.W500,
                fontSize = 18.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        IconButton(
            modifier = Modifier,
            onClick = {
                onLogOut()
            }
        ) {
            Icon(
                painter = painterResource(Res.drawable.logout_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                contentDescription = "logout",
                tint = MaterialTheme.colors.onBackground
            )
        }
    }
}
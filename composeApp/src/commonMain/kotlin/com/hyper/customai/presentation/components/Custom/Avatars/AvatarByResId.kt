package com.hyper.customai.presentation.components.Custom.Avatars

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DrawerDefaults.shape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun AvatarByResId(
    modifier: Modifier = Modifier.size(45.dp),
    resId: DrawableResource,
    containerColor: Color = Color.DarkGray,
    contentColor: Color = MaterialTheme.colors.onBackground,
    shape: Shape = RoundedCornerShape(100),
    contentPadding: PaddingValues = PaddingValues(5.dp),
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .clip(shape)
            .clickable {
                onClick()
            }
            .background(containerColor)
            .padding(contentPadding),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(resId),
            tint = contentColor,
            contentDescription = null
        )
    }
}
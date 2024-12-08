package com.hyper.customai.presentation.components.Custom.Snackbars.ErrorSnackbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarData
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hyperai_custom.composeapp.generated.resources.Res
import hyperai_custom.composeapp.generated.resources.close_24dp_e8eaed_fill0_wght400_grad0_opsz24
import hyperai_custom.composeapp.generated.resources.error_24dp_e8eaed_fill0_wght400_grad0_opsz24
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun ErrorSnackbar(
    modifier: Modifier,
    snackbarData: SnackbarData,
    drawableResource: DrawableResource = Res.drawable.error_24dp_e8eaed_fill0_wght400_grad0_opsz24,
    shape: Shape = RoundedCornerShape(10.dp),
    contentPadding: PaddingValues = PaddingValues(horizontal = 15.dp, vertical = 10.dp),
    containerColor: Color = MaterialTheme.colors.error,
    contentColor: Color = MaterialTheme.colors.onError
) {
    Row(
        modifier = modifier
            .clip(shape)
            .fillMaxWidth()
            .background(containerColor)
            .padding(contentPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Icon(
                painter = painterResource(drawableResource),
                tint = contentColor,
                contentDescription = null
            )

            Text(
                text = snackbarData.message,
                color = contentColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.W500
            )
        }

        IconButton(
            onClick = {
                snackbarData.dismiss()
            }
        ) {
            Icon(
                painter = painterResource(Res.drawable.close_24dp_e8eaed_fill0_wght400_grad0_opsz24),
                tint = contentColor,
                contentDescription = null
            )
        }
    }
}
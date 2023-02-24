package com.sawrose.marvel_showroom.core.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun AppBarIcon(
    imageVector: ImageVector,
    contentDescription: String,
    modifier: Modifier = Modifier,
    onclick: (() -> Unit)? = null,
    ) {
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        tint = LocalContentColor.current.copy(alpha = 0.7f),
        modifier = modifier
            .let {
                 if (onclick != null) {
                     it.clickable(
                         interactionSource = remember { MutableInteractionSource() },
                         indication = rememberRipple(
                             bounded = false,
                             radius = 16.dp
                         ),
                         onClick = onclick
                     )
                 } else {
                     it
                 }
            },
    )
}
package com.sawrose.marvel_showroom.core.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.sawrose.marvel_showroom.core.extension.DevicePreviews

@Composable
fun LoadingContent(
    loading: Boolean,
    content: @Composable () -> Unit
) {
    if (loading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.Center)
        ){
            CircularProgressIndicator()
        }
    } else {
        content()
    }
}


@DevicePreviews
@Composable
fun LoadingContentPreview() {
    LoadingContent(loading = true) {}
}

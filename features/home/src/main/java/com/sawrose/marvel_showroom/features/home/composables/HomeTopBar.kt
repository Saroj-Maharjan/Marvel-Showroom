package com.sawrose.marvel_showroom.features.home.composables

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.sawrose.marvel_showroom.core.extension.DevicePreviews
import com.sawrose.marvel_showroom.features.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar() {
    TopAppBar(title = { Text(text = stringResource(R.string.home_screen_top_bar_title)) })
}

@DevicePreviews
@Composable
fun HomeTopBarPreview() {
    HomeTopBar()
}
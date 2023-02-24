package com.sawrose.marvel_showroom.features.home.composables

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.NavigationRail
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun MarvelNavBottomBar(navController: NavHostController) {
    NavigationRail(
        modifier = Modifier.fillMaxHeight(),
        containerColor = androidx.compose.ui.graphics.Color.Transparent,
    ) {
    }
}
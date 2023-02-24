package com.sawrose.marvel_showroom.ui.main

import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.sawrose.marvel_showroom.navigation.AppNavigation

@Composable
fun MainScreen() {
   Surface {
       AppNavigation()
   }
}
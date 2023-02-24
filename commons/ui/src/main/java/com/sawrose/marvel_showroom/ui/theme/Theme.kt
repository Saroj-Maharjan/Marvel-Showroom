package com.sawrose.marvel_showroom.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable


private val LightColorScheme = lightColorScheme(
    primary = purple500,
    primaryContainer = purple700,
    onPrimary = white,
    surface = white,
    secondary = teal100,
    secondaryContainer = teal500,
    onSecondary = black,
    onSurface = black,
    background = white,
    onBackground = black,
    error = red900,
    onError = white,
)


private val DarkColorScheme = darkColorScheme(
    primary = purple100,
    primaryContainer = purple700,
    onPrimary = black,
    surface = black200,
    secondary = teal100,
    secondaryContainer = teal100,
    onSecondary = black,
    onSurface = white,
    background = black200,
    onBackground = white,
    error = red500,
    onError = black,
)

@Composable
fun MarvelShowroomTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = Typography,
        shapes = Shape,
        content = content
    )
}
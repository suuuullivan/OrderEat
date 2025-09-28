package com.example.ordereat.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val lightScheme = lightColorScheme(
    primary            = primary,
    onPrimary          = Color.White,
    primaryContainer   = primary.lighten(0.85f),
    onPrimaryContainer = Color.Black,

    secondary            = secondary,
    onSecondary          = Color.Black,
    secondaryContainer   = secondary.lighten(0.85f),
    onSecondaryContainer = Color.Black,

    tertiary            = tertiary,
    onTertiary          = Color.Black,
    tertiaryContainer   = tertiary.lighten(0.85f),
    onTertiaryContainer = Color.Black,

    background       = background,
    onBackground     = onBackground,
    surface          = Color.White,
    onSurface        = Color.Black,

    error            = error,
    onError          = Color.White,
)

private val darkScheme = darkColorScheme(
    primary            = primary.darken(0.4f),
    onPrimary          = Color.Black,
    primaryContainer   = primary.darken(0.1f),
    onPrimaryContainer = Color.White,

    secondary            = secondary.darken(0.4f),
    onSecondary          = Color.White,
    secondaryContainer   = secondary.darken(0.1f),
    onSecondaryContainer = Color.Black,

    tertiary            = tertiary.darken(0.4f),
    onTertiary          = Color.Black,
    tertiaryContainer   = tertiary.darken(0.1f),
    onTertiaryContainer = Color.White,

    background       = background,
    onBackground     = onBackground,
    surface          = Color.Black,
    onSurface        = Color.White,

    error            = error.darken(0.4f),
    onError          = Color.Black,
)


@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkScheme else lightScheme,
        typography = AppTypography,
        content = content
    )
}
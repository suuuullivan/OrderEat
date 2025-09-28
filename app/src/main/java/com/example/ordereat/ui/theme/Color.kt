package com.example.ordereat.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp

val primary = Color(0xFF0597F2)
val secondary = Color(0xFFF3AE52)
val tertiary = Color(0xFFB0E3AC)
val error = Color(0xFFE3ACAC)
val background = Color(0xFFF9F9F9)
val onBackground = Color(0xFFB1B1B1)

/**
 * Retourne une couleur “light” (mélange vers le blanc)
 * @param fraction de 0f (couleur de base) à 1f (blanc)
 */
fun Color.lighten(fraction: Float): Color =
    lerp(this, Color.White, fraction)

/**
 * Retourne une couleur “dark” (mélange vers le noir)
 * @param fraction de 0f (couleur de base) à 1f (noir)
 */
fun Color.darken(fraction: Float): Color =
    lerp(this, Color.Black, fraction)
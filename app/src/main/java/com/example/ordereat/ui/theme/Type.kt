package com.example.ordereat.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.ordereat.ui.utils.FontSize
import com.example.ordereat.ui.utils.fontFamilyAvenir

val AppTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = fontFamilyAvenir,
        fontWeight = FontWeight.Black,

        fontSize = FontSize.ULTRA
    ),
    titleMedium = TextStyle(
        fontFamily = fontFamilyAvenir,
        fontWeight = FontWeight.Bold,
        fontSize = FontSize.LARGE
    ),
    bodyLarge = TextStyle(
        fontFamily = fontFamilyAvenir,
        fontWeight = FontWeight.Normal,
        fontSize = FontSize.MEDIUM
    ),
    labelMedium = TextStyle(
        fontFamily = fontFamilyAvenir,
        fontWeight = FontWeight.Normal,
        fontSize = FontSize.MEDIUM,
    ),
)
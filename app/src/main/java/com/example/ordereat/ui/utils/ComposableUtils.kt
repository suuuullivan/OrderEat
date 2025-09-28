package com.example.ordereat.ui.utils

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.ordereat.R

val fontFamilyAvenir = FontFamily(
    Font(R.font.avenir_book, FontWeight.Bold),
    Font(R.font.avenir_black, FontWeight.Black),
    Font(R.font.avenir_heavy, FontWeight.ExtraBold),
    Font(R.font.avenir_light, FontWeight.Light),
    Font(R.font.avenir_regular, FontWeight.Normal)
)

@Composable
fun buttonWithText(text: String, textColor: Color, backgroundColor: Color, navigation: () -> Unit){
    Button(
        onClick =  navigation,
        colors = ButtonDefaults.buttonColors(backgroundColor)
    ) {
        Text(
            text,
            color = textColor
        )
    }
}
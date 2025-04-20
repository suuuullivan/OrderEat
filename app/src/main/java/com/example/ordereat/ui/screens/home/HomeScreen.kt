package com.example.ordereat.ui.screens.home

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(onNavigateToSecond: () -> Unit) {
    Button(onClick = onNavigateToSecond) {
        Text(text = "Voir les restaurants")
    }
}

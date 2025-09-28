package com.example.ordereat.ui.screens.restaurants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ListRestaurantScreen(
    viewModel: ListRestaurantViewModel,
    onRestaurantClick: (id: String) -> Unit
) {
    Column (modifier = Modifier.background(Color.White)){
        Text(text = "Liste des restaurants")

    }
}

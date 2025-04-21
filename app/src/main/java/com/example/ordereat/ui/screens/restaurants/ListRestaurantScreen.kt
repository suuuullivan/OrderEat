package com.example.ordereat.ui.screens.restaurants

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ListRestaurantScreen(
    viewModel: ListRestaurantViewModel,
    onRestaurantClick: (id: String) -> Unit
) {
    Text(text = "Liste des restaurants")
}

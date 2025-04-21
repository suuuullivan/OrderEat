package com.example.ordereat.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.ordereat.R

@Composable
fun HomeScreen(
    onVoirRestaurants: () -> Unit
) {
    Column {
        Text(text = stringResource(R.string.capital_letter_app_name))
        Button(onClick = onVoirRestaurants) {
            Text("Voir les restaurants")
        }
    }
}

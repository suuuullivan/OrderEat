package com.example.ordereat.ui.screens.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.ordereat.R
import com.example.ordereat.ui.utils.Padding
import com.example.ordereat.ui.utils.buttonWithText

@Composable
fun HomeScreen(
    navOnListRestaurant: () -> Unit
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Column(
            Modifier
                .align(Alignment.Center)
                .padding(Padding.MEDIUM),
            verticalArrangement = Arrangement.spacedBy(Padding.SMALL),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.capital_letter_app_name),
                color = Color.White,
                fontSize = 24.sp
            )
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(
                    stringResource(R.string.already_restaurant),
                    color = Color(0xFF0597F2)
                )
            }
            buttonWithText(
                stringResource(R.string.search_restaurant),
                MaterialTheme.colorScheme.primary,
                MaterialTheme.colorScheme.background,
                navOnListRestaurant
            )

        }

        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .aspectRatio(2f)
                .align(Alignment.BottomCenter),
            contentAlignment = Alignment.TopCenter
        ) {
            Canvas(Modifier.matchParentSize()) {
                val radius = size.width / 2f
                val center = Offset(x = radius, y = radius + 70)
                drawCircle(
                    color = Color.White,
                    radius = radius,
                    center = center
                )
            }

            Image(
                painter = painterResource(R.drawable.two_people_command),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .aspectRatio(1f)
            )
        }
    }
}

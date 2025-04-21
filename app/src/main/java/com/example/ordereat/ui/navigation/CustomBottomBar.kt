package com.example.ordereat.ui.navigation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.ordereat.R
import com.example.ordereat.ui.utils.Dimens

@Composable
fun CustomBottomBar(
    currentRoute: String?,
    onTabSelected: (route: String) -> Unit,
    modifier: Modifier = Modifier
) {
    data class Tab(
        val route: String,
        @DrawableRes val icon: Int,
        val title: String
    )

    val tabs = listOf(
        Tab(Screen.ListRestaurant.route, R.drawable.home, "Restos"),
        Tab(Screen.Order.route, R.drawable.order, "Commandes"),
        Tab(Screen.Profile.route, R.drawable.profil, "Profil")
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(Dimens.MASSIVE)
            .background(Color(0xDE6464FF))
            .padding(horizontal = Dimens.MEDIUM),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        tabs.forEach { tab ->
            val selected = tab.route == currentRoute
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable { onTabSelected(tab.route) }
                    .padding(vertical = Dimens.MICRO),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = tab.icon),
                    contentDescription = tab.title,
                    tint = if (selected) Color(0xFF0597F2) else Color(0xFFB1B1B1),
                    modifier = Modifier.size(Dimens.LARGE)
                )
                Text(
                    text = tab.title,
                    fontSize = 12.sp,
                    color = if (selected) Color(0xFF0597F2) else Color(0xFFB1B1B1)
                )
            }
        }
    }
}

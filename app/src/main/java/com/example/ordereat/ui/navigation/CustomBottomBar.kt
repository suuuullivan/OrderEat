package com.example.ordereat.ui.navigation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.ordereat.R
import com.example.ordereat.ui.utils.FontSize
import com.example.ordereat.ui.utils.Height
import com.example.ordereat.ui.utils.Padding

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
        Tab(
            Screen.ListRestaurant.route,
            R.drawable.home,
            stringResource(R.string.bottom_bar_restaurant)
        ),
        Tab(Screen.Order.route, R.drawable.order, stringResource(R.string.bottom_bar_order)),
        Tab(Screen.Profile.route, R.drawable.profil, stringResource(R.string.bottom_bar_profil))
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(Height.MASSIVE)
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = Padding.MEDIUM),
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
                    .padding(vertical = Padding.MICRO),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = tab.icon),
                    contentDescription = tab.title,
                    tint = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.size(Height.LARGE)
                )
                Text(
                    text = tab.title,
                    fontSize = FontSize.SMALL,
                    color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}

package com.example.ordereat.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ordereat.ui.screens.home.HomeScreen
import com.example.ordereat.ui.screens.order.OrderScreen
import com.example.ordereat.ui.screens.profil.ProfileScreen
import com.example.ordereat.ui.screens.restaurants.ListRestaurantScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.systemBars

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomBarScreens = listOf(
        Screen.ListRestaurant.route,
        Screen.Order.route,
        Screen.Profile.route
    )
    val showBottomBar = currentRoute in bottomBarScreens

    Box(modifier = Modifier.fillMaxSize().padding( WindowInsets.systemBars.asPaddingValues())) {
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.fillMaxSize()
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    navOnListRestaurant = {
                        navController.navigate(Screen.ListRestaurant.route)
                    }
                )
            }
            composable(Screen.ListRestaurant.route) {
                ListRestaurantScreen(
                    viewModel = hiltViewModel(),
                    onRestaurantClick = {  }
                )
            }
            composable(Screen.Order.route) {
                OrderScreen(viewModel = hiltViewModel())
            }
            composable(Screen.Profile.route) {
                ProfileScreen(viewModel = hiltViewModel())
            }
        }

        if (showBottomBar) {
            CustomBottomBar(
                currentRoute = currentRoute,
                onTabSelected = { route ->
                    navController.navigate(route) {
                        launchSingleTop = true
                        popUpTo(Screen.ListRestaurant.route) { saveState = true }
                        restoreState = true
                    }
                },
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}
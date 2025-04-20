package com.example.ordereat.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ordereat.ui.navigation.NavigationDestination.Companion.toDestination
import com.example.ordereat.ui.screens.home.HomeScreen
import com.example.ordereat.ui.screens.restaurants.ListRestaurantScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentDestination: MainNavigation by remember(navBackStackEntry) {
        derivedStateOf {
            navBackStackEntry?.toDestination<MainNavigation>() ?: MainNavigation.startDestination
        }
    }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(currentDestination = currentDestination) { selectedDestination ->
                if (currentDestination != selectedDestination) {
                    navController.navigate(selectedDestination) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MainNavigation.startDestination::class.qualifiedName!!,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<MainNavigation.Home> {
                HomeScreen(
                    onNavigateToSecond = {
                        navController.navigate(MainNavigation.Second)
                    }
                )
            }
            // Déclaration de la destination Second
            composable<MainNavigation.Second> {
                ListRestaurantScreen()
            }
        }
    }
}

@Composable
fun BottomNavigationBar(
    currentDestination: MainNavigation,
    onItemSelected: (MainNavigation) -> Unit
) {
    NavigationBar {
        val items = listOf(
            NavigationItem("Accueil", MainNavigation.Home, Icons.Default.Home),
            NavigationItem("Restaurants", MainNavigation.Second, Icons.Default.Create)
        )

        items.forEach { item ->
            NavigationBarItem(
                selected = currentDestination::class == item.destination::class,
                onClick = { onItemSelected(item.destination) },
                icon = { Icon(imageVector = item.icon, contentDescription = item.label) },
                label = { Text(item.label) }
            )
        }
    }
}

data class NavigationItem(
    val label: String,
    val destination: MainNavigation,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)

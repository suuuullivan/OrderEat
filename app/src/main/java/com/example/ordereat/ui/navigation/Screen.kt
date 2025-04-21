package com.example.ordereat.ui.navigation

sealed class Screen(val route: String, val title: String) {
    object Home : Screen("home", "Accueil")
    object ListRestaurant : Screen("list_restaurant", "Restaurants")
    object Order : Screen("order", "Mes Commandes")
    object Profile : Screen("profile", "Mon profil")
}
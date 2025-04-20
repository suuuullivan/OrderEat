package com.example.ordereat.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable

inline fun <reified T : NavigationDestination> NavGraphBuilder.composable(
    noinline content: @Composable () -> Unit
) {
    val route = T::class.qualifiedName ?: error("Route manquante pour la destination")
    composable(route) { content() }
}

fun NavHostController.navigate(
    destination: NavigationDestination,
    builder: NavOptionsBuilder.() -> Unit = {}
) {
    val route = destination::class.qualifiedName ?: error("Route manquante pour la destination")
    navigate(route, builder)
}

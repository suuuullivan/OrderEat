package com.example.ordereat.ui.navigation

import android.os.Bundle
import androidx.navigation.NavBackStackEntry
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

open class NavigationDestination {
    companion object {
        inline fun <reified T : NavigationDestination> NavBackStackEntry.toDestination(): T? {
            return toDestination(T::class, this)
        }

        fun <T : NavigationDestination> toDestination(
            kClass: KClass<T>,
            backStackEntry: NavBackStackEntry?
        ): T? {
            if (backStackEntry == null) return null

            val route = backStackEntry.destination.route ?: ""
            val subclass = kClass.sealedSubclasses.firstOrNull { sub ->
                route.contains(sub.qualifiedName ?: "")
            } ?: return null

            return createInstance(subclass, backStackEntry.arguments)
        }

        private fun <T : NavigationDestination> createInstance(
            kClass: KClass<T>,
            bundle: Bundle?
        ): T? {
            return kClass.primaryConstructor?.let { constructor ->
                val args = constructor.parameters.associateWith { parameter ->
                    bundle?.get(parameter.name)
                }
                constructor.callBy(args)
            } ?: kClass.objectInstance
        }
    }
}

@Serializable
sealed class MainNavigation : NavigationDestination() {
    @Serializable
    data object Home : MainNavigation()

    @Serializable
    data object Second : MainNavigation()

    companion object {
        val startDestination = Home
    }
}

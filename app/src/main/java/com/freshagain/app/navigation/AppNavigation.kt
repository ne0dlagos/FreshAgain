package com.freshagain.app.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.freshagain.app.ui.screens.HomeScreen
import com.freshagain.app.ui.screens.RegistroScreen
import com.freshagain.app.viewmodel.RegistroViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    // Instanciamos el ViewModel aquí
    val registroViewModel: RegistroViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = AppScreens.HomeScreen.route
    ) {
        composable(route = AppScreens.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(route = AppScreens.RegistroScreen.route) {
            // Pasamos el ViewModel a la pantalla
            RegistroScreen(
                navController = navController,
                viewModel = registroViewModel
            )
        }
    }
}
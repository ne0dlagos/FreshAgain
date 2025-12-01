package com.freshagain.app.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.freshagain.app.ui.screens.HomeScreen
import com.freshagain.app.ui.screens.RegistroScreen
import com.freshagain.app.ui.screens.CatalogoScreen
import com.freshagain.app.ui.screens.SubirPrendaScreen
import com.freshagain.app.viewmodel.RegistroViewModel
import com.freshagain.app.viewmodel.PrendaViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    val registroViewModel: RegistroViewModel = viewModel()

    val prendaViewModel: PrendaViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = AppScreens.HomeScreen.route
    ) {
        composable(route = AppScreens.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(route = AppScreens.RegistroScreen.route) {
            RegistroScreen(
                navController = navController,
                viewModel = registroViewModel
            )
        }

        composable(route = AppScreens.Catalogo.route) {
            CatalogoScreen(
                navController = navController,
                viewModel = prendaViewModel
            )
        }

        composable(route = AppScreens.SubirPrenda.route) {
            SubirPrendaScreen(
                navController = navController,
                viewModel = prendaViewModel
            )
        }
    }
}
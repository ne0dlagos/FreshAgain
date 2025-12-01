package com.freshagain.app.navigation

sealed class AppScreens(val route: String) {
    object HomeScreen : AppScreens("home")
    object RegistroScreen : AppScreens("registro")
    object Catalogo : AppScreens("catalogo")
    object SubirPrenda : AppScreens("subir_prenda")
}
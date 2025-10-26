package com.freshagain.app.navigation

/**
 * Sealed class para definir las rutas de navegación de forma segura.
 * Esto previene errores al escribir strings de rutas.
 */
sealed class AppScreens(val route: String) {
    // Objeto para la pantalla Home
    data object HomeScreen : AppScreens("home_screen")

    // Objeto para la pantalla de Registro
    data object RegistroScreen : AppScreens("registro_screen")
}
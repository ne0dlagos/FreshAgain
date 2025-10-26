package com.freshagain.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

// Importamos la pantalla que creamos
import com.freshagain.app.ui.screens.HomeScreen

// ESTA es la importación clave. No es el archivo Theme.kt,
// sino la función Composable "FreshAgainTheme" que está DENTRO de ese archivo.
import com.freshagain.app.ui.theme.AppFreshAgainTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aquí usamos la función del tema para envolver la app
            AppFreshAgainTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Carga nuestra pantalla principal
                    HomeScreen()
                }
            }
        }
    }
}
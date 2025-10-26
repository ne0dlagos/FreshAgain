package com.freshagain.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.freshagain.app.R

/**
 * Pantalla principal (Home) de la aplicación.
 * Muestra el saludo, un botón de acción y el logo.
 */
@OptIn(ExperimentalMaterial3Api::class) // Requerido para TopAppBar
@Composable
fun HomeScreen() {
    // Scaffold provee la estructura base (AppBar, contenido, etc.)
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("FreshAgain") })
        }
    ) { innerPadding ->
        // Column para apilar elementos verticalmente
        Column(
            modifier = Modifier
                .padding(innerPadding) // Padding necesario del Scaffold
                .fillMaxSize()
                .padding(16.dp), // Padding interno para el contenido
            verticalArrangement = Arrangement.spacedBy(20.dp) // Espacio entre elementos
        ) {

            Text(text = "¡Bienvenido a FreshAgain!")

            Button(
                onClick = { /* TODO: Acción de navegación */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ver Catálogo")
            }

            // Imagen del logo
            // IMPORTANTE: Añade una imagen 'logo.png' a /res/drawable/
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo de FreshAgain",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}

/**
 * Vista previa para el diseñador de Android Studio.
 * Nos permite ver la pantalla sin ejecutar la app.
 */
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    // Es buena práctica envolver el Preview en el Tema,
    // pero para simplicidad lo dejamos así por ahora.
    HomeScreen()
}

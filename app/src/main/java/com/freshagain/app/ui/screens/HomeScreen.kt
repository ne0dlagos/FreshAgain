package com.freshagain.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.freshagain.app.R
// Importamos nuestro detector de tamaño
import com.freshagain.app.ui.utils.obtenerWindowSizeClass

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    // 1. Obtenemos la clase de tamaño
    val windowSizeClass = obtenerWindowSizeClass()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("FreshAgain") })
        }
    ) { innerPadding ->

        // 2. Decidimos el layout basado en el ancho
        when (windowSizeClass.widthSizeClass) {
            // Caso Teléfono (Vertical)
            WindowWidthSizeClass.Compact -> {
                LayoutCompacto(
                    modifier = Modifier.padding(innerPadding)
                )
            }
            // Caso Tablet (Horizontal)
            else -> {
                LayoutMedianoOExpandido(
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

/**
 * Layout para pantallas compactas (teléfonos).
 * Apila los elementos verticalmente.
 */
@Composable
private fun LayoutCompacto(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContenidoComun()
    }
}

/**
 * Layout para pantallas medianas o expandidas (tablets).
 * Coloca los elementos horizontalmente.
 */
@Composable
private fun LayoutMedianoOExpandido(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalArrangement = Arrangement.spacedBy(32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Usamos pesos para que la columna de texto e imagen
        // compartan el espacio
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(text = "¡Bienvenido a FreshAgain!")

            Button(
                onClick = { /* TODO: Acción de navegación */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ver Catálogo")
            }
        }

        Spacer(Modifier.width(32.dp))

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo de FreshAgain",
            modifier = Modifier
                .weight(1f)
                .height(250.dp), // Más alto en tablets
            contentScale = ContentScale.Fit
        )
    }
}

/**
 * Elementos comunes para ambos layouts.
 * (En este caso, solo para el compacto para simplificar)
 */
@Composable
private fun ContenidoComun() {
    Text(text = "¡Bienvenido a FreshAgain!")

    Button(
        onClick = { /* TODO: Acción de navegación */ },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Ver Catálogo")
    }

    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "Logo de FreshAgain",
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        contentScale = ContentScale.Fit
    )
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800, name = "Compact Preview")
@Composable
fun HomeScreenCompactPreview() {
    // Vista previa de teléfono
    LayoutCompacto()
}

@Preview(showBackground = true, widthDp = 1280, heightDp = 800, name = "Expanded Preview")
@Composable
fun HomeScreenExpandedPreview() {
    // Vista previa de tablet
    LayoutMedianoOExpandido()
}
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.freshagain.app.R
import com.freshagain.app.navigation.AppScreens
import com.freshagain.app.ui.utils.obtenerWindowSizeClass

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val windowSizeClass = obtenerWindowSizeClass()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("FreshAgain") })
        }
    ) { innerPadding ->

        when (windowSizeClass.widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                LayoutCompacto(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController
                )
            }
            else -> {
                LayoutMedianoOExpandido(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController
                )
            }
        }
    }
}

/**
 * Layout para pantallas compactas (teléfonos).
 */
@Composable
private fun LayoutCompacto(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContenidoComun(navController = navController)
    }
}

/**
 * Layout para pantallas medianas o expandidas (tablets).
 */
@Composable
private fun LayoutMedianoOExpandido(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalArrangement = Arrangement.spacedBy(32.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(text = "¡Bienvenido a FreshAgain!")

            Button(
                onClick = { navController.navigate(AppScreens.RegistroScreen.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Registrarse")
            }
        }

        Spacer(Modifier.width(32.dp))

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo de FreshAgain",
            modifier = Modifier
                .weight(1f)
                .height(250.dp),
            contentScale = ContentScale.Fit
        )
    }
}
@Composable
private fun ContenidoComun(navController: NavController) {
    Text(text = "¡Bienvenido a FreshAgain!")

    Button(
        onClick = { navController.navigate(AppScreens.RegistroScreen.route) },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Registrarse") // <-- 6. Texto del botón
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

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}
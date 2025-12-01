package com.freshagain.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.freshagain.app.model.Prenda
import com.freshagain.app.viewmodel.PrendaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubirPrendaScreen(navController: NavController, viewModel: PrendaViewModel) {
    var titulo by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Vender Prenda") }) }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding).padding(16.dp).fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedTextField(value = titulo, onValueChange = { titulo = it }, label = { Text("Título") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = descripcion, onValueChange = { descripcion = it }, label = { Text("Descripción") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = precio, onValueChange = { precio = it }, label = { Text("Precio") }, modifier = Modifier.fillMaxWidth())

            Button(
                onClick = {
                    val nuevaPrenda = Prenda(
                        titulo = titulo,
                        descripcion = descripcion,
                        precio = precio.toIntOrNull() ?: 0,
                        imagenUrl = "https://via.placeholder.com/150"
                    )
                    viewModel.agregarPrenda(nuevaPrenda) {
                        navController.popBackStack()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Publicar Prenda")
            }
        }
    }
}
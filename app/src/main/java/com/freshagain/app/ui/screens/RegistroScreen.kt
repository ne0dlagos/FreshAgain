package com.freshagain.app.ui.screens

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.freshagain.app.R
import com.freshagain.app.viewmodel.RegistroViewModel
import java.io.File
import java.util.Objects

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroScreen(
    navController: NavController,
    viewModel: RegistroViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    // --- Launchers (Guía 13) ---

    // Launcher para seleccionar imagen de la Galería
    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        viewModel.onImagenChange(uri)
    }

    // URI temporal para guardar la foto de la cámara
    val cameraTempUri = rememberLauncherUri(context)

    // Launcher para tomar foto con la Cámara
    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { success: Boolean ->
        if (success) {
            viewModel.onImagenChange(cameraTempUri)
        }
    }

    // --- UI ---

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Regístrate") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()), // Para que no se corte en pantallas chicas
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Imagen de Perfil
            AsyncImage(
                model = uiState.imagenUri ?: R.drawable.logo, // Muestra logo si no hay imagen
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.height(8.dp))

            // Botones de Cámara y Galería
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                OutlinedButton(onClick = { galleryLauncher.launch("image/*") }) {
                    Text("Galería")
                }
                OutlinedButton(onClick = { cameraLauncher.launch(cameraTempUri) }) {
                    Text("Tomar Foto")
                }
            }

            Spacer(Modifier.height(8.dp))

            // --- Formulario (Guía 11) ---
            OutlinedTextField(
                value = uiState.nombre,
                onValueChange = viewModel::onNombreChange,
                label = { Text("Nombre") },
                isError = uiState.errores.nombre != null,
                supportingText = {
                    uiState.errores.nombre?.let { Text(it) }
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = uiState.correo,
                onValueChange = viewModel::onCorreoChange,
                label = { Text("Correo Electrónico") },
                isError = uiState.errores.correo != null,
                supportingText = {
                    uiState.errores.correo?.let { Text(it) }
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = uiState.clave,
                onValueChange = viewModel::onClaveChange,
                label = { Text("Contraseña") },
                isError = uiState.errores.clave != null,
                supportingText = {
                    uiState.errores.clave?.let { Text(it) }
                },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = uiState.aceptaTerminos,
                    onCheckedChange = viewModel::onAceptaTerminosChange
                )
                Spacer(Modifier.width(8.dp))
                Text("Acepto los términos y condiciones")
            }

            Button(
                onClick = {
                    if (viewModel.validarFormulario()) {
                        // TODO: Paso 4 (Animación y Persistencia)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = uiState.aceptaTerminos
            ) {
                Text("Registrar")
            }
        }
    }
}

/**
 * Función helper para crear una URI temporal donde la cámara guardará la foto.
 */
@Composable
private fun rememberLauncherUri(context: Context): Uri {
    val file = File(context.cacheDir, "temp_image.jpg")
    return FileProvider.getUriForFile(
        Objects.requireNonNull(context),
        context.packageName + ".provider",
        file
    )
}
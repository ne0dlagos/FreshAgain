# FreshAgain

## 1. Descripción del Proyecto

FreshAgain es una tienda (ficticia) de ropa urbana de segunda mano, que requiere una aplicación móvil nativa para Android que permita a los usuarios registrarse, iniciar sesión, explorar un catálogo de prendas y comprar.

## 2. Integrante

* Daniel Lagos

## 3. Funcionalidades Implementadas (Actualizado 01/12/2025)

### Arquitectura y Diseño (Frontend)
* Patrón MVVM: Separación lógica entre UI ('Screens'), Estado ('ViewModel') y Datos ('Repository').
* Jetpack Compose: Interfaz de usuario declarativa moderna.
* Diseño Adaptable: Layouts responsivos para teléfonos (Compact) y tablets (Medium/Expanded).
* Navegación: Gestión de rutas con NavHost.

### Conectividad y Datos
* Conexión a Microservicios: Implementación de Retrofit para comunicar la App con el Backend Spring Boot local.
* CRUD Completo: Funcionalidades para Crear, Leer, Actualizar y Eliminar prendas del catálogo desde la App.
* API Externa (Open-Meteo): Widget en el Home que consume una API pública de clima (JSON) para sugerir outfits según la temperatura de Santiago.
* Gestión de Imágenes: Uso de Coil para carga asíncrona de imágenes y FileProvider para capturas de cámara.

### Calidad y Entrega
* Pruebas Unitarias: Validación de la lógica del `PrendaViewModel` utilizando Kotest y MockK (Cobertura de lógica de negocio).
* APK Firmado: Generación de versión Release firmada con Keystore propio (`freshagain-key.jks`) lista para instalación.

## 4. Pasos para Ejecutar

Para que la aplicación funcione correctamente (especialmente el catálogo), se debe ejecutar el entorno completo:

### Paso 1: Ejecutar el Backend
1.  Clonar el repositorio del Backend (https://github.com/ne0dlagos/FreshAgain-Backend).
2.  Abrir en IntelliJ IDEA.
3.  Ejecutar `FreshAgainServiceApplication`.
4.  Verificar que corra en el puerto 8080.

### Paso 2: Ejecutar la App Android
1.  Clonar este repositorio en Android Studio (Ladybug o superior recomendado).
3.  Sincronizar Gradle.
4.  Ejecutar en Emulador: La app está configurada para apuntar a `http://10.0.2.2:8080/` (localhost del emulador).

## 5. Credenciales y Archivos
* El archivo de firma `.jks` se encuentra en la raíz del proyecto.
* El APK final se encuentra en la carpeta `release` (o en la entrega comprimida).

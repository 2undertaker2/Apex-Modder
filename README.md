# 🔍 Apex Modder - Herramienta de Análisis de Seguridad Android

## 📋 Descripción

**Apex Modder** es una aplicación educativa de análisis de seguridad para aplicaciones Android. Esta herramienta permite identificar vulnerabilidades, analizar permisos, detectar ofuscación de código y generar reportes de seguridad de archivos APK.

### Objetivo del Proyecto
Este proyecto es una iniciativa académica para aprender sobre:
- Ingeniería inversa de aplicaciones Android
- Análisis de seguridad de APK
- Decompilación de código
- Detección de vulnerabilidades
- Desarrollo de herramientas de análisis

---

## ✨ Características Principales

- ✅ **Análisis de Permisos**: Identifica permisos peligrosos solicitados por la app
- ✅ **Detección de Ofuscación**: Analiza si el código está ofuscado
- ✅ **Extracción de Información**: Obtiene datos del archivo APK
- ✅ **Análisis de Librerías**: Lista librerías detectadas en la aplicación
- ✅ **Reporte de Seguridad**: Genera reportes detallados
- ✅ **Búsqueda de Strings**: Busca URLs, claves API y credenciales hardcodeadas

---

## 🛠️ Tecnologías Utilizadas

```
- Lenguaje: Kotlin + Java
- SDK de Android: API 21+
- Herramientas de Análisis:
  * Apktool (desempaquetamiento)
  * JADX (decompilación)
  * Frida (instrumentación)
- Librerías:
  * AndroidX
  * Material Design
  * Bouncy Castle (criptografía)
```

---

## 📦 Estructura del Proyecto

```
Apex-Modder/
│
├── app/
│   ├── src/main/
│   │   ├── java/com/apexmodder/
│   │   │   ├── MainActivity.kt
│   │   │   ├── ApkAnalyzer.kt
│   │   │   ├── SecurityChecker.kt
│   │   │   ├── PermissionAnalyzer.kt
│   │   │   └── ReportGenerator.kt
│   │   │
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   └── activity_main.xml
│   │   │   └── values/
│   │   │       └── strings.xml
│   │   │
│   │   └── AndroidManifest.xml
│   │
│   └── build.gradle
│
├── build.gradle
└── README.md
```

---

## 🚀 Cómo Empezar

### Requisitos Previos
- Android Studio (versión 4.1 o superior)
- JDK 8 o superior
- SDK de Android (API 21+)
- Dispositivo Android o emulador

### Pasos de Instalación

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/2undertaker2/Apex-Modder.git
   cd Apex-Modder
   ```

2. **Abrir en Android Studio**
   - Abre Android Studio
   - File → Open → Selecciona la carpeta del proyecto

3. **Sincronizar Gradle**
   - Android Studio sincronizará automáticamente las dependencias

4. **Ejecutar la aplicación**
   - Conecta un dispositivo Android o abre un emulador
   - Haz clic en "Run" o presiona Shift+F10

---

## 📚 Módulos del Proyecto

### 1. **MainActivity.kt**
Pantalla principal de la aplicación donde el usuario puede:
- Seleccionar un archivo APK
- Ver resultados del análisis
- Navegar entre diferentes opciones

### 2. **ApkAnalyzer.kt**
Módulo responsable de:
- Desempaquetar archivos APK
- Extraer información del manifest
- Obtener datos de la aplicación

### 3. **SecurityChecker.kt**
Realiza análisis de seguridad:
- Verifica vulnerabilidades conocidas
- Analiza patrones de código peligrosos
- Genera alertas de seguridad

### 4. **PermissionAnalyzer.kt**
Analiza permisos:
- Identifica permisos peligrosos
- Clasifica por nivel de riesgo
- Proporciona contexto sobre cada permiso

### 5. **ReportGenerator.kt**
Genera reportes:
- Crea reportes en formato texto o JSON
- Exporta resultados
- Permite compartir análisis

---

## 🔐 Vulnerabilidades que Detecta

```
1. SQL Injection - Querys sin protección
2. Hardcoded Credentials - Contraseñas en código
3. Insecure Storage - Datos sin cifrado
4. Weak Cryptography - Encriptación deficiente
5. Insecure Communication - HTTP en lugar de HTTPS
6. Reverse Engineering - Código fácil de descompilar
7. Debugging Habilitado - debuggable=true
8. Permisos Excesivos - Solicitudes innecesarias
9. Componentes Expuestos - Activities/Services públicas
10. Librerías Vulnerables - Versiones antiguas
```

---

## 📖 Guía de Uso

### Análisis Básico
1. Abre la aplicación
2. Selecciona un archivo APK de tu dispositivo
3. Haz clic en "Analizar"
4. Revisa los resultados

### Interpretación de Resultados
- **Rojo**: Vulnerabilidad crítica
- **Naranja**: Vulnerabilidad media
- **Amarillo**: Advertencia
- **Verde**: Sin problemas detectados

---

## 🎓 Conceptos Educativos

Este proyecto enseña:

### Ingeniería Inversa Android
- Estructura de archivos APK
- Decompilación de bytecode Dalvik
- Análisis de recursos

### Seguridad de Aplicaciones
- Detección de vulnerabilidades
- Análisis de permisos
- Evaluación de riesgos

### Programación Android
- Desarrollo con Kotlin
- Interfaz de usuario
- Manejo de archivos

---

## 🔧 Dependencias

```gradle
dependencies {
    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'androidx.core:core-ktx:1.3.2'
    implementation 'com.google.android.material:material:1.2.1'
    
    // Para análisis de APK
    implementation 'org.apache.commons:commons-compress:1.20'
}
```

---

## 📝 Próximas Características

- [ ] Interfaz gráfica mejorada
- [ ] Análisis de tráfico de red
- [ ] Integración con bases de datos de vulnerabilidades
- [ ] Exportación de reportes en PDF
- [ ] Análisis dinámico con Frida
- [ ] Búsqueda en base de datos de APKs conocidos

---

## ⚠️ Disclaimer Legal

**Este proyecto es únicamente para fines educativos y de investigación académica.**

El uso de esta herramienta debe ser:
- ✅ Autorizado por el propietario de la aplicación
- ✅ Dentro del marco legal
- ✅ Ético y responsable
- ✅ Para propósitos de seguridad legítima

---

## 👨‍💻 Autor

**Estudiante de Ingeniería**: 2undertaker2
**Proyecto Académico**: Análisis de Seguridad en Aplicaciones Android

---

## 📞 Contacto y Soporte

Para preguntas o sugerencias sobre el proyecto:
- GitHub Issues: [Crear un issue](https://github.com/2undertaker2/Apex-Modder/issues)
- Discussions: [Participar en discusiones](https://github.com/2undertaker2/Apex-Modder/discussions)

---

## 📄 Licencia

Este proyecto está bajo la licencia MIT. Ver archivo `LICENSE` para más detalles.

---

**Última actualización**: 2026-02-25
**Versión**: 1.0.0 (Beta)
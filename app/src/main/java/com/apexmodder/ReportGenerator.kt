package com.apexmodder

import java.io.File
import java.text.SimpleDateFormat
import java.util.*

data class SecurityReport(
    val appName: String,
    val packageName: String,
    val versionCode: Int,
    val versionName: String,
    val dangerousPermissions: List<String>,
    val vulnerabilities: List<String>,
    val analysisDate: String,
    val riskScore: Int
)

class ReportGenerator {

    fun generateTextReport(report: SecurityReport): String {
        val sb = StringBuilder()
        sb.append("╔════════════════════════════════════════════════════════════╗\n")
        sb.append("║         REPORTE DE ANÁLISIS DE SEGURIDAD APEX MODDER       ║\n")
        sb.append("╚════════════════════════════════════════════════════════════╝\n\n")
        
        sb.append("📱 INFORMACIÓN DE LA APLICACIÓN\n")
        sb.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
        sb.append("Nombre: \\$\{report.appName}\n")
        sb.append("Paquete: \\$\{report.packageName}\n")
        sb.append("Versión: \\$\{report.versionName} (Código: \\$\{report.versionCode})\n")
        sb.append("Fecha de Análisis: \\$\{report.analysisDate}\n\n")
        
        sb.append("⚠️ PUNTUACIÓN DE RIESGO\n")
        sb.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
        sb.append("Riesgo: \\$\{getRiskLevel(report.riskScore)} (\\$\{report.riskScore}/100)\n")
        sb.append("\\$\{getRiskBar(report.riskScore)}\n\n")
        
        sb.append("🔐 PERMISOS PELIGROSOS DETECTADOS (\\$\{report.dangerousPermissions.size})\n")
        sb.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
        if (report.dangerousPermissions.isEmpty()) {
            sb.append("✅ No se detectaron permisos peligrosos\n\n")
        } else {
            report.dangerousPermissions.forEach { permission ->
                sb.append("❌ \\$permission\n")
                sb.append("   └─ Descripción: \\$\{getPermissionDescription(permission)}\n\n")
            }
        }
        
        sb.append("🚨 VULNERABILIDADES ENCONTRADAS (\\$\{report.vulnerabilities.size})\n")
        sb.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
        if (report.vulnerabilities.isEmpty()) {
            sb.append("✅ No se detectaron vulnerabilidades conocidas\n\n")
        } else {
            report.vulnerabilities.forEachIndexed { index, vuln ->
                sb.append("\\$\{index + 1}. \\$vuln\n")
            }
            sb.append("\n")
        }
        
        sb.append("📋 RECOMENDACIONES\n")
        sb.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n")
        sb.append(getRecommendations(report))
        sb.append("\n")
        
        sb.append("═════════════════════════════════════════════════════════════\n")
        sb.append("Reporte generado por: Apex Modder v1.0\n")
        sb.append("═════════════════════════════════════════════════════════════\n")
        
        return sb.toString()
    }

    fun generateJsonReport(report: SecurityReport): String {
        return """{
  \"appName\": \\$\{report.appName}\",
  \"packageName\": \\$\{report.packageName}\",
  \"versionCode\": \\$\{report.versionCode},
  \"versionName\": \\$\{report.versionName}\",
  \"analysisDate\": \\$\{report.analysisDate}\",
  \"riskScore\": \\$\{report.riskScore},
  \"riskLevel\": \\$\{getRiskLevel(report.riskScore)}\",
  \"dangerousPermissions\": [
    \\$\{report.dangerousPermissions.joinToString(",\n    ") { \"\$it\" }}
  ],
  \"vulnerabilities\": [
    \\$\{report.vulnerabilities.joinToString(",\n    ") { \"\$it\" }}
  ]
}"""
    }

    fun saveReportToFile(report: SecurityReport, filePath: String, format: String = "txt") {
        val content = when (format.lowercase()) {
            "json" -> generateJsonReport(report)
            else -> generateTextReport(report)
        }
        
        val file = File(filePath)
        file.parentFile?.mkdirs()
        file.writeText(content)
    }

    private fun getRiskLevel(score: Int): String {
        return when {
            score >= 80 -> "🔴 CRÍTICO"
            score >= 60 -> "🟠 ALTO"
            score >= 40 -> "🟡 MEDIO"
            score >= 20 -> "🟢 BAJO"
            else -> "✅ MÍNIMO"
        }
    }

    private fun getPermissionDescription(permission: String): String {
        return when (permission) {
            "android.permission.CAMERA" -> "Acceso a la cámara del dispositivo"
            "android.permission.READ_CONTACTS" -> "Lectura de contactos almacenados"
            "android.permission.ACCESS_FINE_LOCATION" -> "Acceso a ubicación GPS precisa"
            "android.permission.READ_SMS" -> "Lectura de mensajes SMS"
            "android.permission.RECORD_AUDIO" -> "Grabación de audio"
            "android.permission.READ_PHONE_STATE" -> "Lectura del estado del teléfono"
            "android.permission.ACCESS_NETWORK_STATE" -> "Acceso al estado de la red"
            "android.permission.INTERNET" -> "Acceso a internet"
            else -> "Permiso: \\$permission"
        }
    }

    private fun getRecommendations(report: SecurityReport): String {
        val sb = StringBuilder()
        
        when {
            report.riskScore >= 80 -> {
                sb.append("⚠️  ALTO RIESGO: Se recomienda NO instalar esta aplicación\n")
                sb.append("   - Solicita demasiados permisos peligrosos\n")
                sb.append("   - Se han detectado vulnerabilidades críticas\n")
                sb.append("   - Considere usar una aplicación alternativa\n")
            }
            report.riskScore >= 60 -> {
                sb.append("⚠️  RIESGO MODERADO: Proceda con precaución\n")
                sb.append("   - Revise los permisos solicitados\n")
                sb.append("   - Considere denegar algunos permisos\n")
                sb.append("   - Monitoree el comportamiento de la app\n")
            }
            report.riskScore >= 40 -> {
                sb.append("ℹ️  RIESGO BAJO: Aplicación aceptable\n")
                sb.append("   - Solo se solicitan algunos permisos moderados\n")
                sb.append("   - No se detectaron vulnerabilidades críticas\n")
            }
            else -> {
                sb.append("✅ RIESGO MÍNIMO: Aplicación segura\n")
                sb.append("   - Solicita permisos estándar\n")
                sb.append("   - No presenta vulnerabilidades detectables\n")
            }
        }
        
        return sb.toString()
    }

    private fun getRiskBar(score: Int): String {
        val filled = score / 10
        val empty = 10 - filled
        val bar = "█".repeat(filled) + "░".repeat(empty)
        return "[\$bar] \$score%"
    }
}
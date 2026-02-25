package com.apexmodder

import android.content.pm.PackageManager
import android.os.Build

class PermissionAnalyzer(private val packageManager: PackageManager) {

    fun getDangerousPermissions(packageName: String): List<String> {
        val dangerousPermissions = mutableListOf<String>()
        val packageInfo = packageManager.getPackageInfo(packageName, PackageManager.GET_PERMISSIONS)
        val requestedPermissions = packageInfo.requestedPermissions ?: return dangerousPermissions
        
        for (permission in requestedPermissions) {
            if (isDangerousPermission(permission)) {
                dangerousPermissions.add(permission)
            }
        }
        
        return dangerousPermissions
    }

    private fun isDangerousPermission(permission: String): Boolean {
        // List of dangerous permissions as outlined by Android documentation
        val dangerousPermissions = listOf(
            "android.permission.CAMERA",
            "android.permission.READ_CONTACTS",
            "android.permission.ACCESS_FINE_LOCATION",
            "android.permission.READ_SMS",
            "android.permission.RECORD_AUDIO",
            // Add more dangerous permissions as necessary
        )
        return dangerousPermissions.contains(permission)
    }
}
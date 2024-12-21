package com.asd.logbox

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LogBox.error("tekshirish","Salom")
        LogBox.debug("tekshirish","Salom")
        LogBox.debug("tekshirish","Salom")
        LogBox.debug("tekshirish","Salom")
        LogBox.debug("tekshirish","Salom")
        LogBox.debug("tekshirish","Salom")
        LogBox.debug("tekshirish","Salom")
        LogBox.debug("tekshirish","Salom")
        LogBox.debug("tekshirish","Salom")


    }

    fun checkOverlayPermission(context: Context) {
        if (!Settings.canDrawOverlays(context)) {
            val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:${context.packageName}"))
            context.startActivity(intent)
        }
    }
}
package com.asd.logbox.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.IBinder
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.asd.logbox.R
import com.asd.logbox.ui.ShowLogDialogActivity
import com.asd.logbox.ui.dialog.LogBoxDialogFragment

class FloatingWidgetService : Service() {

    private lateinit var windowManager: WindowManager
    private lateinit var floatingWidget: View

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()

        Log.d("tekshirish", "onCreate: ochildite")
        windowManager = getSystemService(WINDOW_SERVICE) as WindowManager

        floatingWidget = LayoutInflater.from(this).inflate(R.layout.floating_widget, null)

        // Layout parametrlari
        val params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT
        ).apply {
            gravity = Gravity.TOP or Gravity.START
            x = 50
            y = 100
        }

        floatingWidget.setOnClickListener {
            val intent = Intent(this, ShowLogDialogActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

        windowManager.addView(floatingWidget, params)
    }

    fun showLogDialog(context: Context) {
        val fragmentManager = (context as AppCompatActivity).supportFragmentManager
        val dialogFragment = LogBoxDialogFragment()
        dialogFragment.show(fragmentManager, "LogBoxDialog")
    }

    override fun onDestroy() {
        super.onDestroy()
        windowManager.removeView(floatingWidget)
    }
}
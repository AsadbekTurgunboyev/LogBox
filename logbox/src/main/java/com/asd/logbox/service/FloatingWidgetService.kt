package com.asd.logbox.service

import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.IBinder
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.asd.logbox.R
import com.asd.logbox.ui.ShowLogDialogActivity
import com.asd.logbox.ui.dialog.LogBoxDialogFragment

class FloatingWidgetService : Service(), View.OnTouchListener {

    private lateinit var windowManager: WindowManager
    private lateinit var floatingWidget: View
    private var initialX: Int = 0
    private var initialY: Int = 0
    private var touchX: Float = 0f
    private var touchY: Float = 0f

    private val layoutParams = WindowManager.LayoutParams(
        WindowManager.LayoutParams.WRAP_CONTENT,
        WindowManager.LayoutParams.WRAP_CONTENT,
        WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
        PixelFormat.TRANSLUCENT
    ).apply {
        gravity = Gravity.TOP or Gravity.START
        x = 30
        y = 30
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        windowManager = getSystemService(WINDOW_SERVICE) as WindowManager

        floatingWidget = LayoutInflater.from(this).inflate(R.layout.floating_widget, null)
        floatingWidget.setOnTouchListener(this)

        floatingWidget.setOnClickListener {
            val intent = Intent(this, ShowLogDialogActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

        windowManager.addView(floatingWidget, layoutParams)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::floatingWidget.isInitialized) {
            windowManager.removeView(floatingWidget)
        }
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                initialX = layoutParams.x
                initialY = layoutParams.y
                touchX = event.rawX
                touchY = event.rawY
            }
            MotionEvent.ACTION_MOVE -> {
                layoutParams.x = (initialX + (event.rawX - touchX)).toInt()
                layoutParams.y = (initialY + (event.rawY - touchY)).toInt()
                windowManager.updateViewLayout(v, layoutParams)
            }
            MotionEvent.ACTION_UP ->{
                val intent = Intent(this, ShowLogDialogActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        }
        return true
    }
}
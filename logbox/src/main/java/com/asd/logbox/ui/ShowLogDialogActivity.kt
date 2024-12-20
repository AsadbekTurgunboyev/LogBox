package com.asd.logbox.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.asd.logbox.ui.dialog.LogBoxDialogFragment

class ShowLogDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dialogFragment = LogBoxDialogFragment()
        dialogFragment.show(supportFragmentManager, "LogBoxDialog")


        dialogFragment.setDismissListener {
            finish()
        }
    }
}
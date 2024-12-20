package com.asd.logbox.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.asd.logbox.LogBox
import com.asd.logbox.R
import com.asd.logbox.custom.LogBoxView

class LogBoxDialogFragment : DialogFragment() {
    private var dismissListener: (() -> Unit)? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = LayoutInflater.from(requireContext())
        val view = inflater.inflate(R.layout.dialog_log_box, null)

        val logBoxView = view.findViewById<LogBoxView>(R.id.logBoxView)
        logBoxView.setLogs(LogBox.getLogs())

        builder.setView(view)
        return builder.create()
    }

    fun setDismissListener(listener: () -> Unit) {
        dismissListener = listener
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        dismissListener?.invoke()
    }
}
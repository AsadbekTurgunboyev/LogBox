package com.asd.logbox.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.asd.logbox.R
import com.asd.logbox.data.model.LogEntry
import com.asd.logbox.ui.adapters.LogAdapter

class LogBoxView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle) {

    private val logAdapter = LogAdapter()

    init {

        inflate(context, R.layout.view_log_box, this)

        findViewById<RecyclerView>(R.id.logRecyclerView).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = logAdapter
        }
    }


    fun setLogs(logs: List<LogEntry>) {
        logAdapter.submitList(logs)
    }
}
package com.asd.logbox.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.asd.logbox.R
import com.asd.logbox.data.model.LogEntry
import com.asd.logbox.ui.adapters.diff.LogDiffCallback
import java.util.Date

class LogAdapter : ListAdapter<LogEntry, LogAdapter.LogViewHolder>(LogDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_log, parent, false)
        return LogViewHolder(view)
    }

    override fun onBindViewHolder(holder: LogViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class LogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val logMessage = itemView.findViewById<TextView>(R.id.logMessage)
        private val logTimestamp = itemView.findViewById<TextView>(R.id.logTimestamp)

        fun bind(log: LogEntry) {
            logMessage.text = "[${log.level}] ${log.message}"
            logTimestamp.text = Date(log.timestamp).toString()
        }
    }
}
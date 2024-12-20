package com.asd.logbox.ui.adapters.diff

import androidx.recyclerview.widget.DiffUtil
import com.asd.logbox.data.model.LogEntry

class LogDiffCallback : DiffUtil.ItemCallback<LogEntry>() {
    override fun areItemsTheSame(oldItem: LogEntry, newItem: LogEntry): Boolean {
        return oldItem.timestamp == newItem.timestamp
    }

    override fun areContentsTheSame(oldItem: LogEntry, newItem: LogEntry): Boolean {
        return oldItem == newItem
    }
}
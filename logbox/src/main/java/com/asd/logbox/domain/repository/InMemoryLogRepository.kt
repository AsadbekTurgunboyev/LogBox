package com.asd.logbox.domain.repository

import com.asd.logbox.data.model.LogEntry
import com.asd.logbox.data.repository.LogRepository

class InMemoryLogRepository : LogRepository {
    private val logs = mutableListOf<LogEntry>()

    override fun addLog(log: LogEntry) {
        logs.add(log)
    }

    override fun getLogs(): List<LogEntry> {
        return logs.toList()
    }
}
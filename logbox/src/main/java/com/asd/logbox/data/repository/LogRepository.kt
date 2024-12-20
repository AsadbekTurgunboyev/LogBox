package com.asd.logbox.data.repository

import com.asd.logbox.data.model.LogEntry

interface LogRepository {
    fun addLog(log: LogEntry)
    fun getLogs(): List<LogEntry>
}
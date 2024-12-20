package com.asd.logbox.data.model

data class LogEntry(
    val level: String,
    val message: String,
    val timestamp: Long
)
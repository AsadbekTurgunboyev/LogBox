package com.asd.logbox.data.model

data class LogEntry(
    val level: String,
    val tag: String,
    val message: String,
    val timestamp: Long
)
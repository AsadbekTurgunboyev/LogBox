package com.asd.logbox

import com.asd.logbox.data.model.LogEntry
import com.asd.logbox.data.repository.LogRepository
import com.asd.logbox.utils.LogBoxConfig
import com.asd.logbox.utils.LogLevel

object LogBox {
    private var logRepository: LogRepository? = null
    private var logLevel = LogLevel.DEBUG

    fun init(config: LogBoxConfig.() -> Unit) {
        val configuration = LogBoxConfig().apply(config)
        logLevel = configuration.logLevel
        logRepository = configuration.repository
    }

    fun log(level: LogLevel, message: String) {
        if (level.priority >= logLevel.priority) {
            logRepository?.addLog(
                LogEntry(level = level.name, message = message, timestamp = System.currentTimeMillis())
            )
        }
    }

    fun debug(message: String) = log(LogLevel.DEBUG, message)
    fun info(message: String) = log(LogLevel.INFO, message)
    fun warn(message: String) = log(LogLevel.WARN, message)
    fun error(message: String) = log(LogLevel.ERROR, message)
}
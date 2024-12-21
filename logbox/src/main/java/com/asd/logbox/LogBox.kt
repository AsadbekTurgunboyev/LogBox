package com.asd.logbox

import android.content.Context
import android.content.Intent
import com.asd.logbox.data.model.LogEntry
import com.asd.logbox.data.repository.LogRepository
import com.asd.logbox.service.FloatingWidgetService
import com.asd.logbox.utils.LogBoxConfig
import com.asd.logbox.utils.LogLevel

object LogBox {
    private var logRepository: LogRepository? = null
    private var logLevel = LogLevel.DEBUG

    fun init(context: Context, config: LogBoxConfig.() -> Unit) {
        val configuration = LogBoxConfig().apply(config)
        logLevel = configuration.logLevel
        logRepository = configuration.repository
        context.startService(Intent(context, FloatingWidgetService::class.java))
    }

    private fun log(level: LogLevel, message: String, tag: String) {
        if (level.priority >= logLevel.priority) {
            logRepository?.addLog(
                LogEntry(
                    level = level.name,
                    tag = tag,
                    message = message,
                    timestamp = System.currentTimeMillis()
                )
            )
        }
    }

    fun debug(tag: String, message: String) = log(LogLevel.DEBUG, tag = tag, message = message)
    fun info(tag: String, message: String) = log(LogLevel.INFO, tag = tag, message = message)
    fun warn(tag: String, message: String) = log(LogLevel.WARN, tag = tag, message = message)
    fun error(tag: String, message: String) = log(LogLevel.ERROR, tag = tag, message = message)

    fun getLogs(): List<LogEntry> {
        return logRepository?.getLogs() ?: emptyList()
    }
}
package com.asd.logbox

import com.asd.logbox.utils.LogLevel

interface LogWriter {
    fun write(level: LogLevel, message: String)
}
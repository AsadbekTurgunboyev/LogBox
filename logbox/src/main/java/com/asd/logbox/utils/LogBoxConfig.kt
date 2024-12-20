package com.asd.logbox.utils

import com.asd.logbox.data.repository.LogRepository
import com.asd.logbox.domain.repository.InMemoryLogRepository

class LogBoxConfig {
    var logLevel: LogLevel = LogLevel.DEBUG
    var repository: LogRepository = InMemoryLogRepository()
}
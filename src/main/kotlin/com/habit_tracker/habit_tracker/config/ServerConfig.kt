package com.habit_tracker.habit_tracker.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "server")
data class ServerConfig(
    val port: Int
)

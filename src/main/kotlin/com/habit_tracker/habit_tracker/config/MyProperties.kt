package com.habit_tracker.habit_tracker.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "config")
data class MyProperties(
    val message: String
)

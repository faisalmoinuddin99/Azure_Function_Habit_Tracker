package com.habit_tracker.habit_tracker

import com.habit_tracker.habit_tracker.config.MyProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(
     MyProperties::class
)
class HabitTrackerApplication

fun main(args: Array<String>) {
    runApplication<HabitTrackerApplication>(*args)
}

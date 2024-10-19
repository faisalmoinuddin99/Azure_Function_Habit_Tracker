package com.habit_tracker.habit_tracker.service

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.function.Function

@Component
class UpperCaseFunction {

    @Bean
    fun upperCase(): Function<String, String> {
        return Function { name -> name.uppercase() }
    }
}

package com.habit_tracker.habit_tracker.controller

import com.habit_tracker.habit_tracker.config.MyProperties
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/api/v1")
class HelloController(val properties: MyProperties) {

    @GetMapping("/test")
    fun getMessage(): String {
        val flx: Flux<String> = Flux.just<String>("I ","Flux", " From project", " Reactor   ")

        flx.subscribe({ value ->
            println(value)
        })
        return "My message: ${properties.message}"
    }
}
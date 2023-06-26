package dev.galiev.weather.controller

import dev.galiev.weather.utils.API_KEY
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class MainController {

    @GetMapping
    fun getAPI(): String = API_KEY
}
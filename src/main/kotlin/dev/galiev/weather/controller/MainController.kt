package dev.galiev.weather.controller

import dev.galiev.weather.model.Example
import dev.galiev.weather.service.WeatherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1")
class MainController @Autowired constructor(private val weatherService: WeatherService) {

    @RequestMapping
    fun home(): String = "Welcome"

    @RequestMapping("forecast/{city}")
    fun getWeatherForFive(@PathVariable city: String): List<Example> {
        return weatherService.getWeatherForFive(city)
    }

    @RequestMapping("weather/{city}")
    fun getWeather(@PathVariable city: String): List<Example> {
        return weatherService.getWeather(city)
    }
}
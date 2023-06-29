package dev.galiev.weather.cache

import dev.galiev.weather.model.Geocode
import dev.galiev.weather.model.MainWeather
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.Duration
import java.time.LocalDateTime

@Component
object WeatherCache {
    val geocodes: MutableMap<String, Geocode> = mutableMapOf()
    val weathers: MutableMap<String, MainWeather> = mutableMapOf()

    @Scheduled(fixedRate = 3000)
    fun cacheCleanup() {
        val currentTime = LocalDateTime.now()
        val geocodeIterator = geocodes.values.iterator()

        while (geocodeIterator.hasNext()) {
            val geocode = geocodeIterator.next()

            val geocodeTime = geocode.time

            val geocodeDuration = Duration.between(geocodeTime, currentTime)

            if (geocodeDuration.toSeconds() >= 3) {
                println("CACHE CLEANUP")
                geocodes.clear()
                weathers.clear()
            }
        }
    }
}
package dev.galiev.weather.service

import dev.galiev.weather.cache.WeatherCache
import dev.galiev.weather.model.Geocode
import dev.galiev.weather.model.MainWeather
import dev.galiev.weather.utils.API_KEY
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate


@Service
class WeatherService private constructor(): MappingJackson2HttpMessageConverter() {
    val restTemplate = RestTemplate()
    companion object {
        private val ourInstance = WeatherService()

        fun getInstance(): WeatherService {
            return ourInstance
        }
    }

    init {
        setPrettyPrint(true)
    }

    fun getGeocode(city: String): Geocode {
        val url = "https://geocode.maps.co/search?q=$city"

        return if (WeatherCache.geocodes.containsKey(city)) {
            WeatherCache.geocodes[city]!!
        } else {
            val response: List<Geocode> = restTemplate.exchange(
                url, HttpMethod.GET, null, object: ParameterizedTypeReference<List<Geocode>>() {}).body!!

            WeatherCache.geocodes[city] = response[0]

            response[0]
        }
    }

    fun getWeather(city: String): MainWeather {
        val geocode = getGeocode(city)
        val url = "https://api.openweathermap.org/data/2.5/onecall?lat=${geocode.lat}&lon=${geocode.lon}&exclude=hourly,daily&appid=$API_KEY"

        return if (WeatherCache.weathers.containsKey(city)) {
            WeatherCache.weathers[city]!!
        } else {

            val response: MainWeather = restTemplate.exchange(
                url, HttpMethod.GET, null, object: ParameterizedTypeReference<MainWeather>(){}
            ).body!!
            WeatherCache.weathers[city] = response

            response
        }
    }
}
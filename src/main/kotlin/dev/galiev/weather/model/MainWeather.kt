package dev.galiev.weather.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import java.time.LocalDateTime

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("current")
class MainWeather {
    val time: LocalDateTime = LocalDateTime.now()

    @set:JsonProperty("current")
    @get:JsonProperty("current")
    @JsonProperty("current")
    var current: Current? = null
}
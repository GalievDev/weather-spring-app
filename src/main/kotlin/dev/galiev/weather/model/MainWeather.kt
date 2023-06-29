package dev.galiev.weather.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("current")
class MainWeather {
    @set:JsonProperty("current")
    @get:JsonProperty("current")
    @JsonProperty("current")
    var current: Current? = null
}
package dev.galiev.weather.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("temp", "pressure", "humidity", "weather")
class Current {
    @get:JsonProperty("temp")
    @set:JsonProperty("temp")
    @JsonProperty("temp")
    var temp: Double? = null

    @get:JsonProperty("pressure")
    @set:JsonProperty("pressure")
    @JsonProperty("pressure")
    var pressure: Double? = null

    @get:JsonProperty("humidity")
    @set:JsonProperty("humidity")
    @JsonProperty("humidity")
    var humidity: Double? = null

    @get:JsonProperty("weather")
    @set:JsonProperty("weather")
    @JsonProperty("weather")
    var weather: List<Weather>? = null
}
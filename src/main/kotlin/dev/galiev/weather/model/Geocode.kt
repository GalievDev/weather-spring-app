package dev.galiev.weather.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("lat", "lon")
class Geocode {
    @get:JsonProperty("lat")
    @set:JsonProperty("lat")
    @JsonProperty("lat")
    var lat: Double? = null

    @get:JsonProperty("lon")
    @set:JsonProperty("lon")
    @JsonProperty("lon")
    var lon: Double? = null
}
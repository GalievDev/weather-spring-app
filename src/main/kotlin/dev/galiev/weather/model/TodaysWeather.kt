package dev.galiev.weather.model

import com.fasterxml.jackson.annotation.*


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("today")
class TodaysWeather {
    @get:JsonProperty("today")
    @set:JsonProperty("today")
    @JsonProperty("today")
    var today: Today? = null

    @JsonIgnore
    private val additionalProperties: MutableMap<String, Any> = HashMap()
    @JsonAnyGetter
    fun getAdditionalProperties(): Map<String, Any> {
        return additionalProperties
    }

    @JsonAnySetter
    fun setAdditionalProperty(name: String, value: Any) {
        additionalProperties[name] = value
    }
}
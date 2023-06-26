package dev.galiev.weather.model

import com.fasterxml.jackson.annotation.*


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
    "temp",
    "pressure",
    "humidity",
    "temp_min",
    "temp_max",
    "sea_level",
    "grnd_level",
    "main",
    "description"
)
class Today {
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
    var humidity: Int? = null

    @get:JsonProperty("temp_min")
    @set:JsonProperty("temp_min")
    @JsonProperty("temp_min")
    var tempMin: Double? = null

    @get:JsonProperty("temp_max")
    @set:JsonProperty("temp_max")
    @JsonProperty("temp_max")
    var tempMax: Double? = null

    @get:JsonProperty("sea_level")
    @set:JsonProperty("sea_level")
    @JsonProperty("sea_level")
    var seaLevel: Double? = null

    @get:JsonProperty("grnd_level")
    @set:JsonProperty("grnd_level")
    @JsonProperty("grnd_level")
    var grndLevel: Double? = null

    @get:JsonProperty("main")
    @set:JsonProperty("main")
    @JsonProperty("main")
    var main: String? = null

    @get:JsonProperty("description")
    @set:JsonProperty("description")
    @JsonProperty("description")
    var description: String? = null

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
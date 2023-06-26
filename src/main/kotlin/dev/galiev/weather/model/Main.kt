package dev.galiev.weather.model

import com.fasterxml.jackson.annotation.*


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("temp", "temp_min", "temp_max", "pressure", "sea_level", "grnd_level", "humidity", "temp_kf")
class Main {
    @get:JsonProperty("temp")
    @set:JsonProperty("temp")
    @JsonProperty("temp")
    var temp: Double? = null

    @get:JsonProperty("temp_min")
    @JsonProperty("temp_min")
    var tempMin: Double? = null
        private set

    @get:JsonProperty("temp_max")
    @JsonProperty("temp_max")
    var tempMax: Double? = null
        private set

    @get:JsonProperty("pressure")
    @JsonProperty("pressure")
    var pressure: Double? = null
        private set

    @get:JsonProperty("sea_level")
    @JsonProperty("sea_level")
    var seaLevel: Double? = null
        private set

    @get:JsonProperty("grnd_level")
    @JsonProperty("grnd_level")
    var grndLevel: Double? = null
        private set

    @get:JsonProperty("humidity")
    @set:JsonProperty("humidity")
    @JsonProperty("humidity")
    var humidity: Int? = null

    @get:JsonProperty("temp_kf")
    @set:JsonProperty("temp_kf")
    @JsonProperty("temp_kf")
    var tempKf: Int? = null

    @JsonIgnore
    private val additionalProperties: MutableMap<String, Any> = HashMap()
    @JsonProperty("temp_min")
    fun setTempMin(temp_min: Int) {
        tempMin = temp_min.toDouble()
    }

    @JsonProperty("temp_max")
    fun setTempMax(temp_max: Int) {
        tempMax = temp_max.toDouble()
    }

    @JsonProperty("pressure")
    fun setPressure(i: Int) {
        pressure = i.toDouble()
    }

    @JsonProperty("sea_level")
    fun setSeaLevel(sea_level: Int) {
        seaLevel = sea_level.toDouble()
    }

    @JsonProperty("grnd_level")
    fun setGrndLevel(grnd_level: Int) {
        grndLevel = grnd_level.toDouble()
    }

    @JsonAnyGetter
    fun getAdditionalProperties(): Map<String, Any> {
        return additionalProperties
    }

    @JsonAnySetter
    fun setAdditionalProperty(name: String, value: Any) {
        additionalProperties[name] = value
    }
}
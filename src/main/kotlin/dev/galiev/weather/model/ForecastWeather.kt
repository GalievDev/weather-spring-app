package dev.galiev.weather.model

import com.fasterxml.jackson.annotation.*
import java.io.Serializable

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("date", "time")
class ForecastWeather {
    var time: Time? = null

    @JsonProperty("date")
    private var date: String? = null

    @JsonIgnore
    private val additionalProperties: Serializable = HashMap<String, Any>()
    @JsonProperty("date")
    fun getdate(): String? {
        return date
    }

    @JsonProperty("date")
    fun setdate(date: String?) {
        this.date = date
    }

    @JsonAnyGetter
    fun getAdditionalProperties(): Map<Date, Time> {
        return additionalProperties as Map<Date, Time>
    }

    @JsonAnySetter
    fun setAdditionalProperty(date: Any?, time: Any?) {
        (additionalProperties as HashMap<Any?, Any?>)[date] = time
    }

    override fun toString(): String {
        val buffer = StringBuffer()
        buffer.append(getdate())
        return buffer.toString()
    }
}
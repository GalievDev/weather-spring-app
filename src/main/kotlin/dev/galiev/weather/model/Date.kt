package dev.galiev.weather.model

import com.fasterxml.jackson.annotation.*



@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("time")
class Date {
    @JsonProperty("time")
    private var time: Time? = null

    @JsonIgnore
    private val additionalProperties: MutableMap<String, Any> = HashMap()
    @JsonProperty("time")
    fun gettime(): Time? {
        return time
    }

    @JsonProperty("time")
    fun settime(time: Time?) {
        this.time = time
    }

    @JsonAnyGetter
    fun getAdditionalProperties(): Map<String, Any> {
        return additionalProperties
    }

    @JsonAnySetter
    fun setAdditionalProperty(name: String, value: Any) {
        additionalProperties[name] = value
    }

    override fun toString(): String {
        val buffer = StringBuffer()
        buffer.append(gettime())
        return buffer.toString()
    }
}
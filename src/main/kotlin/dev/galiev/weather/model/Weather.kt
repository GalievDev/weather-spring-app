package dev.galiev.weather.model

import com.fasterxml.jackson.annotation.*


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("id", "main", "description", "icon")
class Weather {
    @get:JsonProperty("id")
    @set:JsonProperty("id")
    @JsonProperty("id")
    var id: Int? = null

    @get:JsonProperty("main")
    @set:JsonProperty("main")
    @JsonProperty("main")
    var main: String? = null

    @get:JsonProperty("description")
    @set:JsonProperty("description")
    @JsonProperty("description")
    var description: String? = null

    @get:JsonProperty("icon")
    @set:JsonProperty("icon")
    @JsonProperty("icon")
    var icon: String? = null

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
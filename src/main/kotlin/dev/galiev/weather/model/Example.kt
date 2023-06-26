package dev.galiev.weather.model

import com.fasterxml.jackson.annotation.*


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("forecast_weather", "todays_weather")
class Example {
    @get:JsonProperty("forecast_weather")
    @set:JsonProperty("forecast_weather")
    @JsonProperty("forecast_weather")
    var forecastWeather: ForecastWeather? = null

    @get:JsonProperty("todays_weather")
    @set:JsonProperty("todays_weather")
    @JsonProperty("todays_weather")
    var todaysWeather: TodaysWeather? = null

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
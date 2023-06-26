package dev.galiev.weather.service

import dev.galiev.weather.model.*
import dev.galiev.weather.utils.API_KEY
import org.json.JSONObject
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.text.SimpleDateFormat


@Service
class WeatherService private constructor(): MappingJackson2HttpMessageConverter() {
    companion object {
        private val ourInstance = WeatherService()

        fun getInstance(): WeatherService {
            return ourInstance
        }
    }

    init {
        setPrettyPrint(true)
    }

    fun getWeatherForFive(city: String): List<Example> {
        val webSiteResponse = "http://api.openweathermap.org/data/2.5/forecast?q=$city&mode=json&appid=${API_KEY}&units=metric"

        val restTemplate = RestTemplate()
        val result: String? = restTemplate.getForObject(webSiteResponse, String::class.java)

        var description: String? = null
        var temp = 0.0
        var pressure = 0
        var humidity = 0
        var temp_min = 0
        var temp_max = 0
        var temp_kf = 0
        var sea_level = 0
        var grnd_level = 0

        var date1: java.util.Date? = null

        var date: String? = null

        var icon: String? = null
        var weatherCondition: String? = null
        var id = 0

        val weatherList: MutableList<Example> = ArrayList()

        val root = JSONObject(result)

        val dfoutput2 = SimpleDateFormat("HH")
        val dfoutput1 = SimpleDateFormat("dd-MM-yyyy")
        val dfinput = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

        val weatherObject = root.getJSONArray("list")

        for (i in 0 until weatherObject.length()) {
            val arrayElement = weatherObject.getJSONObject(i)
            val main = arrayElement.getJSONObject("main")
            temp = main.getFloat("temp").toInt().toDouble()
            pressure = main.getInt("pressure")
            humidity = main.getInt("humidity")
            temp_min = main.getInt("temp_min")
            temp_max = main.getInt("temp_max")
            temp_kf = main.getInt("temp_kf")
            sea_level = main.getInt("sea_level")
            grnd_level = main.getInt("grnd_level")
            description = arrayElement.getJSONArray("weather").getJSONObject(0).getString("description")
            icon = arrayElement.getJSONArray("weather").getJSONObject(0).getString("icon")
            weatherCondition = arrayElement.getJSONArray("weather").getJSONObject(0).getString("main")
            id = arrayElement.getJSONArray("weather").getJSONObject(0).getInt("id")
            date = arrayElement.getString("dt_txt")
            date1 = dfinput.parse(date)
            val fw = ForecastWeather()
            val dt = Date()
            val mn = Main()
            val e = Example()
            val t = Time()
            val w = Weather()
            mn.temp = temp
            mn.setPressure(pressure / 10)
            mn.humidity = humidity
            mn.setGrndLevel(grnd_level)
            mn.setSeaLevel(sea_level)
            mn.tempKf = temp_kf
            mn.setTempMax(temp_max)
            mn.setTempMin(temp_min)
            w.description = description
            w.icon = icon
            w.id = id
            w.main = weatherCondition
            t.time = dfoutput2.format(date1)
            t.main = mn
            t.weather = w
            dt.setAdditionalProperty(dfoutput2.format(date1), t)
            fw.setAdditionalProperty(dfoutput1.format(date1), dt)
            e.forecastWeather = fw
            weatherList.add(e)
        }

        return weatherList
    }

    fun getWeather(city: String): List<Example> {
        val webSiteResponse = "http://api.openweathermap.org/data/2.5/weather?q=$city&mode=json&appid=${API_KEY}&units=metric"

        val restTemplate = RestTemplate()
        val result: String? = restTemplate.getForObject(webSiteResponse, String::class.java)

        var description: String? = null
        var WeatherCondition: String? = null
        var temp: Double
        var temp_min: Double
        var temp_max: Double
        var pressure: Double
        var humidity: Int


        val weatherList: ArrayList<Example> = ArrayList()

        val root = JSONObject(result)

        val weatherObject = root.getJSONArray("weather")

        for (i in 0 until weatherObject.length()) {
            val elementInArray = weatherObject.getJSONObject(i)
            description = elementInArray.getString("description")
            WeatherCondition = elementInArray.getString("main")
        }

        val main = root.getJSONObject("main")

        temp = main.getFloat("temp").toInt().toDouble()
        pressure = main.getInt("pressure").toDouble()
        humidity = main.getInt("humidity")
        temp_min = main.getFloat("temp_min").toInt().toDouble()
        temp_max = main.getFloat("temp_max").toInt().toDouble()


        val tw = TodaysWeather()
        val e = Example()
        val t = Today()

        t.description = description

        t.humidity = humidity
        t.main = WeatherCondition
        t.pressure = pressure

        t.temp = temp
        t.tempMax = temp_max
        t.tempMin = temp_min

        tw.today = t
        e.todaysWeather = tw

        weatherList.add(e)

        return weatherList
    }
}
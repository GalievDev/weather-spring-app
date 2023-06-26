package dev.galiev.weather.utils

import io.github.cdimascio.dotenv.dotenv
import kotlin.reflect.KProperty

class Environment(private val defaultValue: String = ""){
    private val dotenv = dotenv {
        ignoreIfMissing = true
    }

    operator fun getValue(th: Any?, prop: KProperty<*>): String = dotenv[prop.name]
        ?: System.getenv(prop.name)
        ?: defaultValue
}

val API_KEY by Environment()
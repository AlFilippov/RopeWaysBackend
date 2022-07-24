package ru.ropeways.api.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "weather")
data class YandexWeatherProperties(
    val weatherIconTemplate: String,
)
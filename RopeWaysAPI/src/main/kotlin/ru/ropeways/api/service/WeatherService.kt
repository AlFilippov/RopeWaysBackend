package ru.ropeways.api.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import ru.ropeways.api.client.YandexWeatherClient
import ru.ropeways.api.client.dto.Language
import ru.ropeways.api.controller.dto.WeatherDto
import ru.ropeways.api.service.converter.WeatherConverter

@Service
class WeatherService(
    @Suppress("SpringJavaInjectionPointsAutowiringInspection")
    private val yandexWeatherClient: YandexWeatherClient,
    private val weatherConverter: WeatherConverter,
) {
    @Value("\${weather.weatherApiKey:}")
    private lateinit var weatherApiKey: String

    fun getWeatherT0(
        lat: Double,
        lon: Double,
        lang: Language?,
        limit: Int?,
        hours: Boolean?,
        extra: Boolean?,
    ): WeatherDto {
        val weatherResponse = yandexWeatherClient.getWeatherT0(
            lat = lat,
            lon = lon,
            lang = lang?.value,
            apiKey = weatherApiKey,
            limit = limit,
            hours = hours,
            extra = extra
        )
        return weatherConverter.convert(weatherResponse)
    }

    fun getWeatherT1(lat: Double, lon: Double, lang: Language?): WeatherDto {
        val weatherResponse =
            yandexWeatherClient.getWeatherT1(lat = lat, lon = lon, lang = lang?.value, apiKey = weatherApiKey)
        return weatherConverter.convert(weatherResponse)
    }
}
package ru.ropeways.api.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam
import ru.ropeways.api.client.dto.WeatherResponse


/**
Описание эндпойнтов и ответа
https://yandex.ru/dev/weather/doc/dg/concepts/forecast-test.html#req-format
 **/

@FeignClient(
    name = "yandex-weather-api",
    url = "\${weather.yandexWeatherUrl}"
)
interface YandexWeatherClient {
    // Тариф «Тестовый»
    @GetMapping("/forecast")
    fun getWeatherT0(
        @RequestParam(name = "lat") lat: Double,
        @RequestParam(name = "lon") lon: Double,
        @RequestParam(name = "lang", required = false) lang: String?,
        @RequestParam(name = "limit", required = false) limit: Int? = null,
        @RequestParam(name = "hours", required = false) hours: Boolean? = null,
        @RequestParam(name = "extra", required = false) extra: Boolean? = null,
        @RequestHeader(name = "X-Yandex-API-Key") apiKey: String,
    ): WeatherResponse

    // Тариф «Погода на вашем сайте»
    @GetMapping("/informers")
    fun getWeatherT1(
        @RequestParam(name = "lat") lat: Double,
        @RequestParam(name = "lon") lon: Double,
        @RequestParam(name = "lang", required = false) lang: String?,
        @RequestHeader(name = "X-Yandex-API-Key") apiKey: String,
    ): WeatherResponse
}
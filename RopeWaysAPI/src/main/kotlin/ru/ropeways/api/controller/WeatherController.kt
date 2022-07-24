package ru.ropeways.api.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.ropeways.api.client.dto.Language
import ru.ropeways.api.controller.WeatherController.Companion.ROOT_WEATHER
import ru.ropeways.api.service.WeatherService

@RestController
@RequestMapping(ROOT_WEATHER)
class WeatherController(
    private val weatherService: WeatherService,
) {

    @GetMapping(FORECAST)
    fun getWeatherT0(
        @RequestParam("lat") lat: Double,
        @RequestParam("lon") lon: Double,
        @RequestParam("lang", required = false) lang: Language,
        @RequestParam("limit", required = false) limit: Int?,
        @RequestParam("hours", required = false) hours: Boolean = false,
        @RequestParam("extra", required = false) extra: Boolean = false,
    ) = weatherService.getWeatherT0(lat = lat, lon = lon, lang = lang, limit = limit, hours = hours, extra = extra)

    @GetMapping(INFORMERS)
    fun getWeatherT1(
        @RequestParam("lat") lat: Double,
        @RequestParam("lon") lon: Double,
        @RequestParam(name = "lang", required = false) lang: Language,
    ) = weatherService.getWeatherT1(lat = lat, lon = lon, lang = lang)

    companion object {
        const val ROOT_WEATHER = "/weather"
        const val FORECAST = "/forecast"
        const val INFORMERS = "/informers"
    }
}
package ru.ropeways.api.service.converter

import org.springframework.stereotype.Component
import ru.ropeways.api.client.dto.Fact
import ru.ropeways.api.client.dto.Forecast
import ru.ropeways.api.client.dto.Info
import ru.ropeways.api.client.dto.TzInfo
import ru.ropeways.api.client.dto.WeatherResponse
import ru.ropeways.api.configuration.YandexWeatherProperties
import ru.ropeways.api.controller.dto.FactDto
import ru.ropeways.api.controller.dto.ForecastDto
import ru.ropeways.api.controller.dto.InfoDto
import ru.ropeways.api.controller.dto.TzInfoDto
import ru.ropeways.api.controller.dto.WeatherDto

@Component
class WeatherConverter(
    private val weatherProperties: YandexWeatherProperties,
) {

    fun convert(weatherResponse: WeatherResponse): WeatherDto {
        return WeatherDto(
            now = weatherResponse.now,
            now_dt = weatherResponse.now_dt,
            info = getInfo(weatherResponse.info),
            fact = getFact(weatherResponse.fact),
            forecast = getForecast(weatherResponse.forecast)
        )
    }

    private fun getForecast(forecast: List<Forecast>) =
        if (forecast.isEmpty()) {
            emptyList()
        } else {
            forecast.map {
                ForecastDto(
                    date = it.date,
                    date_ts = it.date_ts,
                    week = it.week,
                    sunrise = it.sunrise,
                    sunset = it.sunset,
                    moon_code = it.moon_code,
                    moon_text = it.moon_text
                )
            }
        }

    private fun getFact(fact: Fact?) = fact?.let {
        FactDto(
            temp = fact.temp,
            feels_like = fact.feels_like,
            temp_water = fact.temp_water,
            icon = getIconUrl(fact.icon),
            condition = fact.condition,
            wind_speed = fact.wind_speed,
            wind_gust = fact.wind_gust,
            wind_dir = fact.wind_dir,
            pressure_mm = fact.pressure_mm,
            pressure_pa = fact.pressure_pa,
            humidity = fact.humidity,
            daytime = fact.daytime,
            polar = fact.polar,
            season = fact.season,
            obs_time = fact.obs_time,
            is_thunder = fact.is_thunder,
            prec_type = fact.prec_type,
            prec_strength = fact.prec_strength,
            cloudness = fact.cloudness,
            phenom_icon = getIconUrl(fact.phenom_icon),
            phenom_condition = fact.phenom_condition,
        )
    }

    private fun getIconUrl(icon: String?) = icon?.let { weatherProperties.weatherIconTemplate.format(icon) }

    private fun getInfo(info: Info?) = info?.let {
        InfoDto(
            lat = info.lat,
            lon = info.lon,
            url = info.url,
            def_pressure_mm = info.def_pressure_mm,
            def_pressure_pa = info.def_pressure_pa,
            tzinfo = getTzinfo(info.tzinfo)
        )
    }

    private fun getTzinfo(tzinfo: TzInfo?) =
        tzinfo?.let {
            TzInfoDto(
                offset = tzinfo.offset,
                abbr = tzinfo.abbr,
                name = tzinfo.name,
                dst = tzinfo.dst
            )
        }
}
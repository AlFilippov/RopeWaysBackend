package ru.ropeways.api.controller.dto

import ru.ropeways.api.client.dto.TzInfo

data class WeatherDto(
    val now: Long,
    val now_dt: String,
    val info: InfoDto?,
    val fact: FactDto?,
    val forecast: List<ForecastDto> = emptyList(),
)

data class InfoDto(
    val lat: Double,
    val lon: Double,
    val def_pressure_mm: Int,
    val def_pressure_pa: Int,
    val url: String,
    val tzinfo: TzInfoDto?,
)

data class FactDto(
    val temp: Int?,
    val feels_like: Int?,
    val temp_water: Int?,
    val icon: String?, // перевод на ссылку
    val condition: String?,
    val wind_speed: Double?,
    val wind_gust: Double?,
    val wind_dir: String?,
    val pressure_mm: Int?,
    val pressure_pa: Int?,
    val humidity: Int?,
    val daytime: String?,
    val polar: Boolean?,
    val season: String?,
    val obs_time: Long?,
    val is_thunder: Boolean?,
    val prec_type: Int?,
    val prec_strength: Float?,
    val cloudness: Int?,
    val phenom_icon: String?, // перевести ссылку
    val phenom_condition: String?
)

data class ForecastDto(
    val date: String?,
    val date_ts: Long?,
    val week: Int?,
    val sunrise: String?,
    val sunset: String?,
    val moon_code: Int?,
    val moon_text: String?
)

data class TzInfoDto(
    val offset: Long,
    val name: String,
    val abbr: String,
    val dst: Boolean,
)
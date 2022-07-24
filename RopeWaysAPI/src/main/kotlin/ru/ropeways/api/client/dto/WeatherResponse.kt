package ru.ropeways.api.client.dto

data class WeatherResponse(
    val now: Long,
    val now_dt: String,
    val info: Info?,
    val fact: Fact?,
    val forecast: List<Forecast> = emptyList(),
)

data class Info(
    val lat: Double,
    val lon: Double,
    val def_pressure_mm: Int,
    val def_pressure_pa: Int,
    val url: String,
    val tzinfo: TzInfo?
)

data class Fact(
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

data class Forecast(
    val date: String?,
    val date_ts: Long?,
    val week: Int?,
    val sunrise:String?,
    val sunset: String?,
    val moon_code: Int?,
    val moon_text: String?
)

data class TzInfo(
    val offset: Long,
    val name: String,
    val abbr: String,
    val dst: Boolean
)
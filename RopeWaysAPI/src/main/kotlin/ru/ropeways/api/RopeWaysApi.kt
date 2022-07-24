package ru.ropeways.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.cloud.openfeign.EnableFeignClients
import ru.ropeways.api.configuration.YandexWeatherProperties

@EnableFeignClients
@SpringBootApplication
@EnableConfigurationProperties(value = [
    YandexWeatherProperties::class
])
class RopeWaysApi

fun main(args: Array<String>) {
    SpringApplication.run(RopeWaysApi::class.java, *args)
}
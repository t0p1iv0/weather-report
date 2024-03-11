package ru.aston.weather_service.dto;

public record Weather(
        String name,
        double tempC,
        String condition
) {
}

package ru.aston.weather_service.service;

import jakarta.servlet.http.HttpServletRequest;
import ru.aston.weather_service.repository.WeatherRepository;

import java.time.Instant;

public class StatisticService {

    private WeatherRepository repository = new WeatherRepository();

    public void storeRequestData(HttpServletRequest req) {
        var ip = req.getRemoteAddr();
        var time = Instant.now().getEpochSecond();

        repository.createRecord(ip, time);
    }
}

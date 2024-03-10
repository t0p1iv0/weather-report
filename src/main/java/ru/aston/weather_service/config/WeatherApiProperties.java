package ru.aston.weather_service.config;

import lombok.Data;

import java.io.IOException;
import java.util.Properties;

@Data
public class WeatherApiProperties {
    private final String token;
    private final String baseUrl;
    private final String current;

    public WeatherApiProperties() {
        Properties props = new Properties();

        try {
            props.load(getClass().getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.token = props.getProperty("token");
        this.baseUrl = props.getProperty("apiUrl");
        this.current = props.getProperty("current");
    }
}

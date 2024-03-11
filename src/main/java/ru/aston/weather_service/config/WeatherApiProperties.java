package ru.aston.weather_service.config;

import lombok.Getter;

import java.io.IOException;
import java.util.Properties;

@Getter
public class WeatherApiProperties {
    private final String token;
    private final String baseUrl;
    private final String currentUrl;
    private final String defaultLang;

    public WeatherApiProperties() {
        Properties props = new Properties();

        try {
            props.load(getClass().getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.token = props.getProperty("token");
        this.baseUrl = props.getProperty("api_url");
        this.currentUrl = props.getProperty("current");
        this.defaultLang = props.getProperty("default_lang");
    }
}

package ru.aston.weather_service.config;

import lombok.Getter;

@Getter
public class WeatherApiProperties {
    private final String token;
    private final String baseUrl;
    private final String currentUrl;
    private final String defaultLang;

    public WeatherApiProperties() {
        var props = ApplicationProperties.getProperties();

        this.token = props.getProperty("token");
        this.baseUrl = props.getProperty("api_url");
        this.currentUrl = props.getProperty("current");
        this.defaultLang = props.getProperty("default_lang");
    }
}

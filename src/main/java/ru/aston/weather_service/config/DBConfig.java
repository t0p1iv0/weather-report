package ru.aston.weather_service.config;

import lombok.Getter;

@Getter
public class DBConfig {
    private final String login;
    private final String password;
    private final String url;

    public DBConfig() {
        var props = ApplicationProperties.getProperties();

        this.login = props.getProperty("db_login");
        this.password = props.getProperty("db_password");
        this.url = props.getProperty("db_url");
    }
}

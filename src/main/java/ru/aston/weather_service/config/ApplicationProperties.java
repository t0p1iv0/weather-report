package ru.aston.weather_service.config;

import java.io.IOException;
import java.util.Properties;

public class ApplicationProperties {
    private static final Properties props = new Properties();

    private ApplicationProperties() {
    }

    public static Properties getProperties() {
        if (props.isEmpty()) {
            try {
                props.load(ApplicationProperties.class.getResourceAsStream("/config.properties"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return props;
    }
}

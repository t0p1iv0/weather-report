package ru.aston.weather_service.service;

import jakarta.servlet.http.HttpServletRequest;
import ru.aston.weather_service.config.WeatherApiProperties;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class WeatherService {

    private final WeatherApiProperties props = new WeatherApiProperties();
    public HttpResponse<String> getCurrentWeather(HttpServletRequest req) {
        try {

            var client = HttpClient.newHttpClient();
            var city = req.getParameter("city");

            if (city.isEmpty())
                throw new IllegalArgumentException();

            return client.send(
                    HttpRequest.newBuilder()
                            .uri(new URI(props.getBaseUrl() + props.getCurrent() + "q=" + city))
                            .setHeader("key", props.getToken())
                            .timeout(Duration.ofSeconds(10))
                            .GET()
                            .build(),
                    HttpResponse.BodyHandlers.ofString()
                    );

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

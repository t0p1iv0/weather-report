package ru.aston.weather_service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import jakarta.servlet.http.HttpServletRequest;
import ru.aston.weather_service.config.WeatherApiProperties;
import ru.aston.weather_service.dto.Weather;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WeatherService {

    private final WeatherApiProperties props = new WeatherApiProperties();
    private final ObjectMapper mapper = new JsonMapper();
    private final HttpClient client = HttpClient.newHttpClient();
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public String getCurrentWeather(HttpServletRequest req) {
        try {
            var city = req.getParameter("city");
            var lang = req.getParameter("lang");

            if (lang == null || lang.isEmpty())
                lang = props.getDefaultLang();

            if (city.isEmpty())
                throw new IllegalArgumentException();

            var apiResp = client.send(
                    HttpRequest.newBuilder()
                            .uri(new URI(props.getBaseUrl() + props.getCurrentUrl()
                                    + "q=" + city + "&lang=" + lang))
                            .setHeader("key", props.getToken())
                            .timeout(Duration.ofSeconds(10))
                            .GET()
                            .build(),
                    HttpResponse.BodyHandlers.ofString())
                    .body();

            logger.log(Level.INFO, "received message from WeatherAPI: " + apiResp);

            var jsonTree = mapper.readTree(apiResp);

            return mapper.writeValueAsString(
                    new Weather(jsonTree.get("location").get("name").asText(),
                    jsonTree.get("current").get("temp_c").asDouble(),
                    jsonTree.get("current").get("condition").get("text").asText())
            );

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

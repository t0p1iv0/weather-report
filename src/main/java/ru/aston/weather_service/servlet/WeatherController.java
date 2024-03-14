package ru.aston.weather_service.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.aston.weather_service.service.StatisticService;
import ru.aston.weather_service.service.WeatherService;

import java.io.IOException;

@WebServlet("/current")
public class WeatherController extends HttpServlet {
    private final WeatherService weatherService = new WeatherService();
    private final StatisticService statisticService = new StatisticService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        statisticService.storeRequestData(req);
        var payload = weatherService.getCurrentWeather(req);
        resp.getWriter().println(payload);
    }
}

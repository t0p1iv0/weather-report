package ru.aston.weather_service.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.aston.weather_service.service.WeatherService;

import java.io.IOException;

@WebServlet("/current")
public class WeatherController extends HttpServlet {

    private final WeatherService service = new WeatherService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var payload = service.getCurrentWeather(req).body();
        resp.getWriter().println(payload);
    }
}

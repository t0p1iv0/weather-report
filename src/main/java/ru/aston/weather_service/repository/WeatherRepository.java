package ru.aston.weather_service.repository;

import ru.aston.weather_service.dao.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WeatherRepository {

    private final String create = "insert into req_stat(ip, time) values(?, ?);";

    public void createRecord(String ip, Long time) {
        try (PreparedStatement statement = DBConnection.getConnection().prepareStatement(create)) {
            statement.setString(1, ip);
            statement.setLong(2, time);

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

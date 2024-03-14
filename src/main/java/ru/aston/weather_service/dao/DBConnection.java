package ru.aston.weather_service.dao;

import org.postgresql.Driver;
import ru.aston.weather_service.config.DBConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final DBConfig config = new DBConfig();

    private static Connection connection = null;

    private DBConnection(){}

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                DriverManager.registerDriver(new Driver());
                return connection = DriverManager.getConnection(
                        config.getUrl(), config.getLogin(), config.getPassword()
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

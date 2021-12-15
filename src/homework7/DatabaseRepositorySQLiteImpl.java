package homework7;

import java_core.homework7.entity.WeatherData;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRepositorySQLiteImpl implements DatabaseRepository {

    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    String filename = null;
    String createTableQuery = "CREATE TABLE IF NOT EXISTS weather (\n" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "city TEXT NOT NULL,\n" +
            "date_time TEXT NOT NULL,\n" +
            "weather_text TEXT NOT NULL,\n" +
            "temperature REAL NOT NULL,\n" +
            ");";
    String insertWeatherQuery = "INSERT INTO weather (city, date_time, weather_text, temperature) VALUES (?,?,?,?)";

    public DatabaseRepositorySQLiteImpl() {
        filename = ApplicationGlobalState.getInstance().getDbFileName();
    }

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
        return connection;
    }

    private void createTableIfNotExists() {
        try (Connection connection = getConnection()) {
            connection.createStatement().execute(createTableQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean saveWeatherData(WeatherData weatherData) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement saveWeather = connection.prepareStatement(insertWeatherQuery)) {
            saveWeather.setString(1, weatherData.getCity());
            saveWeather.setString(2, weatherData.getLocalDate());
            saveWeather.setString(3, weatherData.getText());
            saveWeather.setDouble(4, weatherData.getTemperature());
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Failure on saving weather object");
    }

    @Override
    public List<WeatherData> getAllSavedData() throws IOException {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM weather");
            List<WeatherData> resultList = new ArrayList<WeatherData>();
            while (resultSet.next()) {
                WeatherData tableLine = new WeatherData();
                String city = resultSet.getString("city");
                tableLine.setCity(city);
                String date_time = resultSet.getString("date_time");
                tableLine.setLocalDate(date_time);
                String weather_text = resultSet.getString("weather_text");
                tableLine.setText(weather_text);
                double temperature = resultSet.getDouble("temperature");
                tableLine.setTemperature(temperature);
                resultList.add(tableLine);
            }
            return resultList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new IOException("Not implemented exception");
    }

    public void finalizeDB() {
        try {
            preparedStatement.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void performDropTable() throws SQLException {
        statement.executeUpdate("DROP TABLE");
    }
}


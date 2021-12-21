package homework7;

import java_core.homework7.entity.WeatherData;

import java.io.IOException;
import java.util.ArrayList;

public interface WeatherProvider {

    ArrayList<WeatherData> getWeather() throws IOException;
}

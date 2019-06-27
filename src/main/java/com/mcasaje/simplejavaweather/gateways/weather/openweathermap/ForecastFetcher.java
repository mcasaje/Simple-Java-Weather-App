package com.mcasaje.simplejavaweather.gateways.weather.openweathermap;

import com.mcasaje.simplejavaweather.models.weather.WeatherData;
import com.mcasaje.simplejavaweather.models.weather.WeatherDataFactory;
import com.mcasaje.simplejavaweather.utils.http.HTTPRequestor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;

class ForecastFetcher {

    private static final Logger logger = LoggerFactory.getLogger(ForecastFetcher.class);
    static final String URL_FORMAT = "https://openweathermap.org/data/2.5/weather/"
            + "?appid=b6907d289e10d714a6e88b30761fae22&id=%s&units=metric";

    static WeatherData getWeather(HTTPRequestor requestor,
                                  WeatherDataFactory factory,
                                  String cityID) throws IOException {
        String urlAddress = createURLAddress(URL_FORMAT, cityID);
        HttpURLConnection connection = requestor.getRequest(urlAddress);
        String response = ResponseReader.readResponse(connection);
        WeatherData weatherData = ForecastParser.parseResponseForWeatherData(factory, response);
        requestor.closeConnection(connection);
        return weatherData;
    }

    static String createURLAddress(String urlFormat, String cityID) {
        String urlAddress = String.format(urlFormat, cityID);
        logger.info("Using URL to find forecast: " + urlAddress);
        return urlAddress;
    }

}

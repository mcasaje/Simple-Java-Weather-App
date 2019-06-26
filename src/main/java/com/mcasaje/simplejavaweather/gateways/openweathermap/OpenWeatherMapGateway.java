package com.mcasaje.simplejavaweather.gateways.openweathermap;

import java.io.IOException;

public class OpenWeatherMapGateway implements WeatherGateway {

    @Override
    public WeatherData getWeatherData(String city, String countryCode) {
        try {
            String cityID = CityIDFetcher.getCityID(city, countryCode);
            // TODO: make request to get weather data using city ID
            // TODO: parse the data
            return null;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

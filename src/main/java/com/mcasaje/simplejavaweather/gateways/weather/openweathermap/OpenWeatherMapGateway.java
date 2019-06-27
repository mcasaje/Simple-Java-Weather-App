package com.mcasaje.simplejavaweather.gateways.weather.openweathermap;

import com.mcasaje.simplejavaweather.gateways.weather.WeatherGateway;
import com.mcasaje.simplejavaweather.models.weather.WeatherData;
import com.mcasaje.simplejavaweather.models.weather.WeatherDataFactory;
import com.mcasaje.simplejavaweather.utils.http.HTTPRequestor;
import com.mcasaje.simplejavaweather.utils.regex.RegexParser;

import javax.inject.Inject;
import java.io.IOException;

public class OpenWeatherMapGateway implements WeatherGateway {

    private WeatherDataFactory weatherDataFactory;
    private HTTPRequestor requestor;
    private RegexParser regexParser;

    @Inject
    public OpenWeatherMapGateway(WeatherDataFactory weatherDataFactory,
                                 HTTPRequestor requestor,
                                 RegexParser regexParser) {
        this.weatherDataFactory = weatherDataFactory;
        this.requestor = requestor;
        this.regexParser = regexParser;
    }

    @Override
    public WeatherData getWeatherData(String city, String countryCode) {
        try {
            String cityID = CityIDFetcher.getCityID(requestor, regexParser, city, countryCode);
            return ForecastFetcher.getWeather(requestor, weatherDataFactory, cityID);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

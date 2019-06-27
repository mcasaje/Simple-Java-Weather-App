package com.mcasaje.simplejavaweather.resources.weather.dto;

import java.util.Date;

public class SimpleWeatherDTO implements WeatherDTO {

    private final String currentDate;
    private final String location;
    private final String forecast;
    private final String celsius;
    private final String fahrenheit;
    private final String sunrise;
    private final String sunset;

    SimpleWeatherDTO(String location,
                     String weatherForecast,
                     String celsius,
                     String fahrenheit,
                     String sunrise,
                     String sunset) {
        this.location = location;
        this.forecast = weatherForecast;
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.currentDate = (new Date()).toString();
    }

    @Override
    public String currentDate() {
        return currentDate;
    }

    public String getLocation() {
        return location;
    }

    public String getForecast() {
        return forecast;
    }

    public String getCelsius() {
        return celsius;
    }

    public String getFahrenheit() {
        return fahrenheit;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }
}

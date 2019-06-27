package com.mcasaje.simplejavaweather.resources.weather.dto;

public interface WeatherDTO {

    String currentDate();

    String getLocation();

    String getForecast();

    String getCelsius();

    String getFahrenheit();

    String getSunrise();

    String getSunset();

}

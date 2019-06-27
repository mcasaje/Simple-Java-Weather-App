package com.mcasaje.simplejavaweather.models.weather;

public interface WeatherData {

    String getLocationName();

    String getWeatherDescription();

    String getTempInCelsius();

    String getTempInFahrenheit();

    String getSunriseStandardTime();

    String getSunsetStandardTime();

}

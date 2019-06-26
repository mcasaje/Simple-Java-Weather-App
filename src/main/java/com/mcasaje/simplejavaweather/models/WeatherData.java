package com.mcasaje.simplejavaweather.models;

public interface WeatherData {

    String getLocationName();

    String getWeatherDescription();

    String getTempInCelsius();

    String getSunriseMilitaryTime();

    String getSunsetMilitaryTime();

    String getTempInFahrenheit();

    String getSunriseStandardTime();

    String getSunsetStandardTime();

}

package com.mcasaje.simplejavaweather.gateways.openweathermap;

public interface WeatherData {

    String getLocationName();

    String getWeatherDescription();

    String getTemperatureCelsius();

    String getTemperatureFahrenheit();

    String getSunriseMilitaryTime();

    String getSunsetMilitaryTime();

}

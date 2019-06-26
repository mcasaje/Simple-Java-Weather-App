package com.mcasaje.simplejavaweather.models;

public interface WeatherDataFactory {

    WeatherData create(String locationName,
                       String weatherDescription,
                       String tempInCelsius,
                       String sunriseMilitaryTime,
                       String sunsetMilitaryTime);

}

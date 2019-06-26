package com.mcasaje.simplejavaweather.models;

public class SimpleWeatherDataFactory implements WeatherDataFactory {

    @Override
    public SimpleWeatherData create(String locationName,
                                    String weatherDescription,
                                    String tempInCelsius,
                                    String sunriseMilitaryTime,
                                    String sunsetMilitaryTime) {
        return new SimpleWeatherData(locationName,
                                     weatherDescription,
                                     tempInCelsius,
                                     sunriseMilitaryTime,
                                     sunsetMilitaryTime);
    }
}

package com.mcasaje.simplejavaweather.models.weather;

public interface WeatherDataFactory {

    WeatherData create(String locationName,
                       String weatherDescription,
                       Double tempInCelsius,
                       Double tempInFahrenheit,
                       String sunriseStandardTime,
                       String sunsetStandardTime);

}

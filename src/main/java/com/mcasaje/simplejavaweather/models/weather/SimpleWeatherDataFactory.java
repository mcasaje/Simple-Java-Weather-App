package com.mcasaje.simplejavaweather.models.weather;

public class SimpleWeatherDataFactory implements WeatherDataFactory {

    @Override
    public SimpleWeatherData create(String locationName,
                                    String weatherDescription,
                                    Double tempInCelsius,
                                    Double tempInFahrenheit,
                                    String sunriseStandardTime,
                                    String sunsetStandardTime) {
        return new SimpleWeatherData(locationName,
                                     weatherDescription,
                                     tempInCelsius,
                                     tempInFahrenheit,
                                     sunriseStandardTime,
                                     sunsetStandardTime);
    }
}

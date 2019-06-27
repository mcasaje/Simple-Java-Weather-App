package com.mcasaje.simplejavaweather.models.weather;

import java.math.BigDecimal;

public class SimpleWeatherDataFactory implements WeatherDataFactory {

    @Override
    public SimpleWeatherData create(String locationName,
                                    String weatherDescription,
                                    BigDecimal tempInCelsius,
                                    BigDecimal tempInFahrenheit,
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

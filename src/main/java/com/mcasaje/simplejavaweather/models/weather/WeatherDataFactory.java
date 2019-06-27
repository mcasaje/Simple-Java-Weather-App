package com.mcasaje.simplejavaweather.models.weather;

import java.math.BigDecimal;

public interface WeatherDataFactory {

    WeatherData create(String locationName,
                       String weatherDescription,
                       BigDecimal tempInCelsius,
                       BigDecimal tempInFahrenheit,
                       String sunriseStandardTime,
                       String sunsetStandardTime);

}

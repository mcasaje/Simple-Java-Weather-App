package com.mcasaje.simplejavaweather.models.weather;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SimpleWeatherData implements WeatherData {

    private final String locationName;
    private final String weatherDescription;
    private final String tempInCelsius;
    private final String tempInFahrenheit;
    private final String sunriseStandardTime;
    private final String sunsetStandardTime;

    public SimpleWeatherData(String locationName,
                             String weatherDescription,
                             BigDecimal tempInCelsius,
                             BigDecimal tempInFahrenheit,
                             String sunriseStandardTime,
                             String sunsetStandardTime) {
        this.locationName = locationName;
        this.weatherDescription = capitalize(weatherDescription);
        this.tempInCelsius = tempInCelsius.setScale(1, RoundingMode.FLOOR) + " C";
        this.tempInFahrenheit = tempInFahrenheit.setScale(1, RoundingMode.FLOOR) + " F";
        this.sunriseStandardTime = sunriseStandardTime;
        this.sunsetStandardTime = sunsetStandardTime;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public String getTempInCelsius() {
        return tempInCelsius;
    }

    public String getTempInFahrenheit() {
        return tempInFahrenheit;
    }

    public String getSunriseStandardTime() {
        return sunriseStandardTime;
    }

    public String getSunsetStandardTime() {
        return sunsetStandardTime;
    }

    private String capitalize(String s) {
        String firstLetter = s.substring(0, 1);
        String restOfString = s.substring(1);
        return firstLetter.toUpperCase() + restOfString;
    }

}

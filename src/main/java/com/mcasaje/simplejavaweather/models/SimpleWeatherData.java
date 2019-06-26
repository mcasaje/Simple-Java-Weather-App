package com.mcasaje.simplejavaweather.models;

public class SimpleWeatherData implements WeatherData {

    private final String locationName;
    private final String weatherDescription;
    private final String tempInCelsius;
    private final String tempInFahrenheit;
    private final String sunriseMilitaryTime;
    private final String sunsetMilitaryTime;
    private final String sunriseStandardTime;
    private final String sunsetStandardTime;

    public SimpleWeatherData(String locationName,
                             String weatherDescription,
                             String tempInCelsius,
                             String sunriseMilitaryTime,
                             String sunsetMilitaryTime) {
        this.locationName = locationName;
        this.weatherDescription = weatherDescription;
        this.tempInCelsius = tempInCelsius;
        this.sunriseMilitaryTime = sunriseMilitaryTime;
        this.sunsetMilitaryTime = sunsetMilitaryTime;
        this.tempInFahrenheit = ""; // TODO
        this.sunriseStandardTime = ""; // TODO
        this.sunsetStandardTime = ""; // TODO
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

    public String getSunriseMilitaryTime() {
        return sunriseMilitaryTime;
    }

    public String getSunsetMilitaryTime() {
        return sunsetMilitaryTime;
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

}

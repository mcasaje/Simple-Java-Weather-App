package com.mcasaje.simplejavaweather.resources.weather.dto;

import com.mcasaje.simplejavaweather.models.weather.WeatherData;

public class SimpleWeatherDTOFactory implements WeatherDTOFactory {

    @Override
    public WeatherDTO create(WeatherData data) {
        String location = data.getLocationName();
        String forecast = data.getWeatherDescription();
        String celsius = data.getTempInCelsius();
        String fahrenheit = data.getTempInFahrenheit();
        String sunrise = data.getSunriseStandardTime();
        String sunset = data.getSunsetStandardTime();
        return new SimpleWeatherDTO(location, forecast, celsius, fahrenheit, sunrise, sunset);
    }
}

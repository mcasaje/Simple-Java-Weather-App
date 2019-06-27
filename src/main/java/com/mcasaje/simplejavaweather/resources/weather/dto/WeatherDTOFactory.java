package com.mcasaje.simplejavaweather.resources.weather.dto;

import com.mcasaje.simplejavaweather.models.weather.WeatherData;

public interface WeatherDTOFactory {

    WeatherDTO create(WeatherData weatherData);

}

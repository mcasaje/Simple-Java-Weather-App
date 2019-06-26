package com.mcasaje.simplejavaweather.gateways.weather;

import com.mcasaje.simplejavaweather.models.WeatherData;

public interface WeatherGateway {

    WeatherData getWeatherData(String city, String countryCode);

}

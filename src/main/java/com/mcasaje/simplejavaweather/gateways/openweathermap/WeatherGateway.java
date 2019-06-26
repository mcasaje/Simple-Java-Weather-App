package com.mcasaje.simplejavaweather.gateways.openweathermap;

public interface WeatherGateway {

    WeatherData getWeatherData(String city, String countryCode);

}

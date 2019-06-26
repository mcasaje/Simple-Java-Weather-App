package com.mcasaje.simplejavaweather.gateways.weather.openweathermap;

import com.jayway.jsonpath.JsonPath;
import com.mcasaje.simplejavaweather.models.WeatherData;
import com.mcasaje.simplejavaweather.models.WeatherDataFactory;

class ForecastParser {

    static WeatherData parseResponseForWeatherData(WeatherDataFactory factory, String response) {

        String locationName = getJsonProperty(response, "$.name");
        String weatherDescription = getJsonProperty(response, "$.weather[0].description");
        String tempInCelsius = getJsonProperty(response, "$.main.temp");
        String sunriseMilitaryTime = getJsonProperty(response, "$.sys.sunrise");
        String sunsetMilitaryTime = getJsonProperty(response, "$.sys.sunset");

        return factory.create(locationName,
                              weatherDescription,
                              tempInCelsius,
                              sunriseMilitaryTime,
                              sunsetMilitaryTime);
    }

    // TODO: Decouple from JsonPath - ie. move to another package
    static String getJsonProperty(String json, String selector) {
        return JsonPath.read(json, selector).toString();
    }

}

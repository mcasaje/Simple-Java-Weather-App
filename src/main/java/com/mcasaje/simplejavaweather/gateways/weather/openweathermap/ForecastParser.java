package com.mcasaje.simplejavaweather.gateways.weather.openweathermap;

import com.jayway.jsonpath.JsonPath;
import com.mcasaje.simplejavaweather.models.weather.WeatherData;
import com.mcasaje.simplejavaweather.models.weather.WeatherDataFactory;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

class ForecastParser {

    static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

    static WeatherData parseResponseForWeatherData(WeatherDataFactory factory, String response) {

        String locationName = getJsonProperty(response, "$.name");
        String weatherDescription = getJsonProperty(response, "$.weather[0].description");
        String rawTempInCelsius = getJsonProperty(response, "$.main.temp");
        String sunriseUnixTime = getJsonProperty(response, "$.sys.sunrise");
        String sunsetUnixTime = getJsonProperty(response, "$.sys.sunset");
        String timezoneOffset = getJsonProperty(response, "$.timezone");

        Double tempInCelsius = Double.parseDouble(rawTempInCelsius);
        Double tempInFahrenheit = convertCelsiusToFahrenheit(rawTempInCelsius);
        String sunriseStandardTime = convertUnixToStandardTime(sunriseUnixTime, timezoneOffset);
        String sunsetStandardTime = convertUnixToStandardTime(sunsetUnixTime, timezoneOffset);

        return factory.create(locationName,
                              weatherDescription,
                              tempInCelsius,
                              tempInFahrenheit,
                              sunriseStandardTime,
                              sunsetStandardTime);
    }

    // TODO: Move to time package
    static String convertUnixToStandardTime(String rawUnixTime, String rawTimeZoneOffset) {
        long unixTime = Long.parseLong(rawUnixTime);
        int timezoneOffset = Integer.parseInt(rawTimeZoneOffset);
        int timezoneOffsetHours = timezoneOffset / 60 / 60;
        ZoneOffset zoneOffset = ZoneOffset.ofHoursMinutesSeconds(timezoneOffsetHours, 0, 0);
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(unixTime, 0, zoneOffset);
        return localDateTime.format(formatter);
    }

    // TODO: Move to temperature package
    static Double convertCelsiusToFahrenheit(String rawCelsius) {
        double celsius = Double.parseDouble(rawCelsius);
        double fahrenheit = (celsius * 9.0 / 5.0) + 32.0;
        return fahrenheit;
    }

    // TODO: Decouple from JsonPath - ie. move to another package
    static String getJsonProperty(String json, String selector) {
        return JsonPath.read(json, selector).toString();
    }

}

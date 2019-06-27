package com.mcasaje.simplejavaweather.resources.weather;

import com.mcasaje.simplejavaweather.gateways.weather.WeatherGateway;
import com.mcasaje.simplejavaweather.models.weather.WeatherData;
import com.mcasaje.simplejavaweather.resources.weather.dto.WeatherDTOFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;

@Path("/weather")
public class GetWeather {

    private static final Logger logger = LoggerFactory.getLogger(GetWeather.class);
    private WeatherGateway gateway;
    private WeatherDTOFactory dtoFactory;

    @Inject
    public GetWeather(WeatherGateway gateway, WeatherDTOFactory dtoFactory) {
        this.gateway = gateway;
        this.dtoFactory = dtoFactory;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object getWeather(@QueryParam("location") String location) {
        String[] input = location.split(",");
        Arrays.stream(input).forEach(String::trim);
        try {
            String city = input[0];
            String countryCode = input.length > 1 ? input[1] : "";
            WeatherData weatherData = gateway.getWeatherData(city, countryCode);
            return dtoFactory.create(weatherData);
        }
        catch (Exception e) {
            logger.error("Could not get weather data for " + location, e);
        }
        return "No weather data found";
    }
}

package com.mcasaje.simplejavaweather.resources;

import com.mcasaje.simplejavaweather.gateways.openweathermap.WeatherGateway;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/weather")
public class GetWeather {

    private WeatherGateway gateway;

    @Inject
    public GetWeather(WeatherGateway gateway) {
        this.gateway = gateway;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getWeather() {
        String weather = "No weather data found.";
        gateway.getWeatherData("Vancouver", "CA");
        return weather;
    }
}

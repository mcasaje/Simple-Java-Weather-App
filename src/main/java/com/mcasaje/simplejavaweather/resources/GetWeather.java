package com.mcasaje.simplejavaweather.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/weather")
public class GetWeather {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getWeather() {
        String weather = "No weather data found.";
        return weather;
    }
}

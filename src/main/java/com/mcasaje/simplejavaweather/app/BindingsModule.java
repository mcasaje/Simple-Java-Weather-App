package com.mcasaje.simplejavaweather.app;

import com.google.inject.AbstractModule;
import com.mcasaje.simplejavaweather.gateways.weather.WeatherGateway;
import com.mcasaje.simplejavaweather.gateways.weather.openweathermap.OpenWeatherMapGateway;
import com.mcasaje.simplejavaweather.models.weather.SimpleWeatherDataFactory;
import com.mcasaje.simplejavaweather.models.weather.WeatherDataFactory;
import com.mcasaje.simplejavaweather.resources.weather.dto.SimpleWeatherDTOFactory;
import com.mcasaje.simplejavaweather.resources.weather.dto.WeatherDTOFactory;
import com.mcasaje.simplejavaweather.utils.http.HTTPRequestor;
import com.mcasaje.simplejavaweather.utils.http.SimpleHTTPRequestor;
import com.mcasaje.simplejavaweather.utils.regex.RegexParser;
import com.mcasaje.simplejavaweather.utils.regex.SimpleRegexParser;

// TODO: Break up binding module by package
public class BindingsModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(WeatherDTOFactory.class).to(SimpleWeatherDTOFactory.class);
        bind(HTTPRequestor.class).to(SimpleHTTPRequestor.class);
        bind(RegexParser.class).to(SimpleRegexParser.class);
        bind(WeatherDataFactory.class).to(SimpleWeatherDataFactory.class);
        bind(WeatherGateway.class).to(OpenWeatherMapGateway.class);
    }

}

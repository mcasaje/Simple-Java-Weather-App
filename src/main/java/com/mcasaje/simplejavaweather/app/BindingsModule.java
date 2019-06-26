package com.mcasaje.simplejavaweather.app;

import com.google.inject.AbstractModule;
import com.mcasaje.simplejavaweather.gateways.openweathermap.WeatherGateway;
import com.mcasaje.simplejavaweather.gateways.openweathermap.OpenWeatherMapGateway;

// TODO: Break up binding module by package
public class BindingsModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(WeatherGateway.class).to(OpenWeatherMapGateway.class);
    }

}

package com.mcasaje.simplejavaweather.gateways.weather.openweathermap;

import org.junit.Assert;
import org.junit.Test;

public class CityIDFetcherTest {

    @Test
    public void createCityIDUrlAddress_testGivenCityAndCountryCodeThenReturnsExpectedUrlAddress() {
        final String city = "MyCity";
        final String countryCode = "GB";
        final String expectedUrlAddress = String.format(CityIDFetcher.URL_FORMAT, city + ",%20" + countryCode);
        String actualUrlAddress = CityIDFetcher.createURLAddress(CityIDFetcher.URL_FORMAT, city, countryCode);
        Assert.assertEquals(expectedUrlAddress, actualUrlAddress);
    }

}

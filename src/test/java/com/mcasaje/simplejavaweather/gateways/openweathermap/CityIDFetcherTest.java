package com.mcasaje.simplejavaweather.gateways.openweathermap;

import org.junit.Assert;
import org.junit.Test;

public class CityIDFetcherTest {

    @Test
    public void createCityIDUrlAddress_testGivenCityAndCountryCodeThenReturnsExpectedUrlAddress() {
        final String city = "MyCity";
        final String countryCode = "GB";
        final String expectedUrlAddress = String.format(CityIDFetcher.URL_FORMAT, city + ",%20" + countryCode);
        String actualUrlAddress = CityIDFetcher.createCityIDUrlAddress(city, countryCode);
        Assert.assertEquals(expectedUrlAddress, actualUrlAddress);
    }

    @Test
    public void parseResponseForCityID_testGivenSampleResponseThenFindsCityID() {
        final String expectedCityID = "6173331";
        final String sampleResponse = "?({\"message\":\"accurate\",\"cod\":\"200\",\"count\":1," +
                "\"list\":[{\"id\":6173331,\"name\":\"Vancouver\",\"coord\":{\"lat\":49.2624,\"lon\":-123.1156}," +
                "\"main\":{\"temp\":292.14,\"pressure\":1010,\"humidity\":45,\"temp_min\":290.37,\"temp_max\":293" +
                ".15},\"dt\":1561520369,\"wind\":{\"speed\":3.6,\"deg\":140},\"sys\":{\"country\":\"CA\"}," +
                "\"rain\":null,\"snow\":null,\"clouds\":{\"all\":90},\"weather\":[{\"id\":804,\"main\":\"Clouds\"," +
                "\"description\":\"overcast clouds\",\"icon\":\"04n\"}]}]})";
        String actualCityID = CityIDFetcher.parseResponseForCityID(sampleResponse);
        Assert.assertEquals(expectedCityID, actualCityID);
    }

}

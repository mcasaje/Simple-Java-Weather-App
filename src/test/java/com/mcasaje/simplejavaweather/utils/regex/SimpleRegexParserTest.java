package com.mcasaje.simplejavaweather.utils.regex;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleRegexParserTest {

    RegexParser sut;

    @Before
    public void setup() {
        sut = new SimpleRegexParser();
    }

    @Test
    public void parse_testWhenCalledThenReturnsExpectedString() {
        final String expectedString = "6173331";
        final String regex = "\"id\":([^,]+)";
        final String source = "?({\"message\":\"accurate\",\"cod\":\"200\",\"count\":1," +
                "\"list\":[{\"id\":6173331,\"name\":\"Vancouver\",\"coord\":{\"lat\":49.2624,\"lon\":-123.1156}," +
                "\"main\":{\"temp\":292.14,\"pressure\":1010,\"humidity\":45,\"temp_min\":290.37,\"temp_max\":293" +
                ".15},\"dt\":1561520369,\"wind\":{\"speed\":3.6,\"deg\":140},\"sys\":{\"country\":\"CA\"}," +
                "\"rain\":null,\"snow\":null,\"clouds\":{\"all\":90},\"weather\":[{\"id\":804,\"main\":\"Clouds\"," +
                "\"description\":\"overcast clouds\",\"icon\":\"04n\"}]}]})";
        String actualCityID = sut.parse(source, regex);
        Assert.assertEquals(expectedString, actualCityID);
    }

}

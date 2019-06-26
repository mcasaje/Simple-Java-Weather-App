package com.mcasaje.simplejavaweather.gateways.weather.openweathermap;

import com.mcasaje.simplejavaweather.utils.http.HTTPRequestor;
import com.mcasaje.simplejavaweather.utils.regex.RegexParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;

class CityIDFetcher {

    private static final Logger logger = LoggerFactory.getLogger(CityIDFetcher.class);
    private static final String CITY_ID_REGEX = "\"id\":([^,]+)";

    static final String URL_FORMAT = "http://openweathermap.org/data/2.5/find?" +
            "callback=?&q=%s&type=like&sort=population&cnt=30&appid=b6907d289e10d714a6e88b30761fae22";

    static String getCityID(HTTPRequestor requestor, RegexParser regexParser, String city, String countryCode) throws
            IOException {
        String urlAddress = createURLAddress(URL_FORMAT, city, countryCode);
        HttpURLConnection connection = requestor.getRequest(urlAddress);
        String response = ResponseReader.readResponse(connection);
        String cityID = regexParser.parse(response, CITY_ID_REGEX);
        requestor.closeConnection(connection);
        return cityID;
    }

    static String createURLAddress(String urlFormat, String city, String countryCode) {
        String locationString = countryCode == null || countryCode.isEmpty() ? city : city + ",%20" + countryCode;
        String urlAddress = String.format(urlFormat, locationString);
        logger.info("Using URL to find city ID: " + urlAddress);
        return urlAddress;
    }

}

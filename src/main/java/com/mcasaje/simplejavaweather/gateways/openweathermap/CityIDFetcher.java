package com.mcasaje.simplejavaweather.gateways.openweathermap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CityIDFetcher {

    private final static Logger logger = LoggerFactory.getLogger(CityIDFetcher.class);

    final static String URL_FORMAT = "http://openweathermap.org/data/2.5/find?" +
            "callback=?&q=%s&type=like&sort=population&cnt=30&appid=b6907d289e10d714a6e88b30761fae22";

    static String getCityID(String city, String countryCode) throws IOException {
        String urlAddress = createCityIDUrlAddress(city, countryCode);
        HttpURLConnection connection = HttpRequestHandler.getRequest(urlAddress);
        String response = ResponseReader.readResponse(connection);
        String cityID = parseResponseForCityID(response);
        HttpRequestHandler.closeConnection(connection);
        return cityID;
    }

    static String createCityIDUrlAddress(String city, String countryCode) {
        String locationString = city + ",%20" + countryCode;
        String urlAddress = String.format(URL_FORMAT, locationString);
        logger.info("Using URL to find city ID: " + urlAddress);
        return urlAddress;
    }

    static String parseResponseForCityID(String response) {
        // Using regex here because response is not valid JSON
        Pattern pattern = Pattern.compile("\"id\":([^,]+)");
        Matcher matcher = pattern.matcher(response);
        boolean foundMatch = matcher.find();
        String cityID = "";
        if (foundMatch) {
            cityID = matcher.group(1);
            logger.info("Found city ID: " + cityID);
        }
        else {
            logger.info("City ID was not found");
        }
        return cityID;
    }

}

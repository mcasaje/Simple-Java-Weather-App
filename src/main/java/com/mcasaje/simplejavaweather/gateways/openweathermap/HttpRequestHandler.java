package com.mcasaje.simplejavaweather.gateways.openweathermap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

// TODO: Move this out into a general HTTP request package
class HttpRequestHandler {

    private final static Logger logger = LoggerFactory.getLogger(HttpRequestHandler.class);

    static HttpURLConnection getRequest(final String urlAddress) throws IOException {
        logger.info("GET " + urlAddress);
        URL url = new URL(urlAddress);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        return connection;
    }

    static void closeConnection(HttpURLConnection connection) {
        connection.disconnect();
    }

}

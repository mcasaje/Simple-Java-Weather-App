package com.mcasaje.simplejavaweather.utils.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimpleHTTPRequestor implements HTTPRequestor {

    private final static Logger logger = LoggerFactory.getLogger(SimpleHTTPRequestor.class);

    public HttpURLConnection getRequest(final String urlAddress) {
        try {
            logger.info("GET " + urlAddress);
            URL url = new URL(urlAddress);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            return connection;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection(HttpURLConnection connection) {
        connection.disconnect();
    }

}

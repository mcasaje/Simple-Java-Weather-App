package com.mcasaje.simplejavaweather.utils.http;

import java.net.HttpURLConnection;

public interface HTTPRequestor {

    HttpURLConnection getRequest(String urlAddress);

    void closeConnection(HttpURLConnection connection);

}

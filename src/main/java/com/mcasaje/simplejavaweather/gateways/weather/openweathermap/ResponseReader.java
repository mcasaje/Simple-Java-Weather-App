package com.mcasaje.simplejavaweather.gateways.weather.openweathermap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

class ResponseReader {

    static String readResponse(HttpURLConnection connection) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuffer stringBuffer = new StringBuffer();
        bufferedReader.lines().forEachOrdered(stringBuffer::append);
        return stringBuffer.toString();
    }

}

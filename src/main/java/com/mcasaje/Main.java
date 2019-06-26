package com.mcasaje;

import com.mcasaje.simplejavaweather.app.CORSResponseFilter;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 */
public class Main {

    // TODO: Pull these variables out into a configuration file or as environment variables
    public static final String BASE_URI = "http://localhost:8080/simplejavaweather/";
    public static final String PACKAGE_ROOT = "com.mcasaje";

    public static HttpServer startServer() {
        final ResourceConfig resourceConfig = new ResourceConfig().packages(PACKAGE_ROOT);
        resourceConfig.register(new CORSResponseFilter());
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), resourceConfig);
    }

    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                                                 + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        server.stop();
    }
}


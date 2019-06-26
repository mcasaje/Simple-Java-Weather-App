package com.mcasaje;

import com.google.inject.Guice;
import com.google.inject.Module;
import com.mcasaje.simplejavaweather.app.BindingsModule;
import com.mcasaje.simplejavaweather.app.CORSResponseFilter;
import io.logz.guice.jersey.JerseyModule;
import io.logz.guice.jersey.JerseyServer;
import io.logz.guice.jersey.configuration.JerseyConfiguration;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // TODO: Pull these variables out into a configuration file or as environment variables
    public static final String PACKAGE_ROOT = "com.mcasaje.simplejavaweather.resources";

    public static JerseyServer startServer() throws Exception {
        final ResourceConfig resourceConfig = new ResourceConfig().packages(PACKAGE_ROOT);
        resourceConfig.register(new CORSResponseFilter());

        JerseyConfiguration configuration = JerseyConfiguration.builder()
                .addPackage(PACKAGE_ROOT)
                .addPort(8080)
                .withResourceConfig(resourceConfig)
                .build();

        List<Module> modules = new ArrayList<>();
        modules.add(new JerseyModule(configuration));
        modules.add(new BindingsModule());

        JerseyServer server = Guice.createInjector(modules)
                .getInstance(JerseyServer.class);
        server.start();
        return server;
    }

    public static void main(String[] args) throws Exception {
        final JerseyServer server = startServer();
        System.out.println("Jersey app started with WADL available at /application.wadl\nHit enter to stop it...");
        System.in.read();
        server.stop();
    }
}

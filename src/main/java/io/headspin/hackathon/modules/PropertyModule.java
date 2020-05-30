package io.headspin.hackathon.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Key;
import com.google.inject.name.Names;
import io.headspin.hackathon.annotations.Url;
import io.headspin.hackathon.annotations.WaitDuration;
import io.headspin.hackathon.exceptions.InvalidEnvException;
import io.headspin.hackathon.properties.SystemProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertyModule extends AbstractModule {

    @Override
    public void configure() {
        Properties envProps = loadProperties();
        Names.bindProperties(binder(), envProps);
        bind(Key.get(String.class, Url.class)).toInstance(envProps.getProperty("url"));
        bind(Key.get(String.class, WaitDuration.class)).toInstance(envProps.getProperty("wait"));
    }

    private Properties loadProperties() {
        String envFile = String.format("envs/%s.properties",
                SystemProperties.ENV.toLowerCase());
        Properties envProps = new Properties();
        try {
            InputStream envStream = this.getClass().getClassLoader()
                    .getResourceAsStream(envFile);
            envProps.load(Objects.requireNonNull(envStream));
        } catch (IOException | NullPointerException e) {
            throw new InvalidEnvException(SystemProperties.ENV);
        }
        return envProps;
    }
}

package io.headspin.hackathon.modules;

import com.google.inject.AbstractModule;
import io.headspin.hackathon.clients.SiteClient;

public class SiteModule extends AbstractModule {

    @Override
    public void configure() {
        bind(SiteClient.class);
    }
}

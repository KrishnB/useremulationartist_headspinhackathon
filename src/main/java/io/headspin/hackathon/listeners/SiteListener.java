package io.headspin.hackathon.listeners;

import com.google.inject.Injector;
import io.headspin.hackathon.clients.SiteClient;
import io.headspin.hackathon.modules.PropertyModule;
import io.headspin.hackathon.modules.SiteModule;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.util.logging.Logger;

public class SiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        Injector siteInjector = suite.getParentInjector().createChildInjector(new SiteModule(), new PropertyModule());
        Logger logger = siteInjector.getInstance(Logger.class);
        logger.info("Verifying if site is up");
        siteInjector.getInstance(SiteClient.class).terminateIfSiteIsDown();
    }
}

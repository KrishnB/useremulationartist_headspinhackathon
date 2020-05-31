package io.headspin.hackathon.listeners;

import com.google.inject.Injector;
import io.headspin.hackathon.clients.SiteClient;
import io.headspin.hackathon.io.LogWriter;
import io.headspin.hackathon.modules.PropertyModule;
import io.headspin.hackathon.modules.SiteModule;
import io.headspin.hackathon.site.Constants;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.util.logging.Logger;

import static io.headspin.hackathon.reports.ReportLogger.log;

public class SiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        Injector siteInjector = suite.getParentInjector().createChildInjector(new SiteModule(), new PropertyModule());
        Logger logger = siteInjector.getInstance(Logger.class);
        log("Verifying if site is up");
        siteInjector.getInstance(SiteClient.class).terminateIfSiteIsDown();
        String logFolder = siteInjector.getInstance(LogWriter.class).createLogFolder();
        suite.setAttribute(Constants.LOG_FOLDER, logFolder);
    }
}

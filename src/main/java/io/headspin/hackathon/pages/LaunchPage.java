package io.headspin.hackathon.pages;

import com.google.inject.Inject;
import io.headspin.hackathon.annotations.Url;
import io.headspin.hackathon.models.Site;

import java.util.logging.Logger;

public class LaunchPage extends BasePage {

    @Inject
    @Url
    String url;

    @Inject
    Logger logger;

    public void launch() {
        logger.info("Launching url => "+url);
        get(url);
    }

    public Site getSiteDetails() {
        Site siteDetails = new Site().toBuilder().title(title()).build();
        logger.info("Site Details => "+siteDetails.toString());
        return siteDetails;
    }

    public LaunchPage get() {
        return (LaunchPage) init(this);
    }
}

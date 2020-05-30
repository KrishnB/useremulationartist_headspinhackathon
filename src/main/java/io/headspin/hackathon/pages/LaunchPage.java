package io.headspin.hackathon.pages;

import com.google.inject.Inject;
import io.headspin.hackathon.annotations.Url;
import io.headspin.hackathon.models.Site;

import static io.headspin.hackathon.reports.ReportLogger.log;

public class LaunchPage extends BasePage {

    @Inject
    @Url
    String url;


    public void launch() {
        log("Launching site => "+url);
        get(url);
    }

    public Site getSiteDetails() {
        Site siteDetails = new Site().toBuilder().title(title()).build();
        log("Site Details => "+siteDetails.toString());
        return siteDetails;
    }

    public LaunchPage get() {
        return (LaunchPage) init(this);
    }
}

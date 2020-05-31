package io.headspin.hackathon.pages;

import com.google.inject.Inject;
import io.headspin.hackathon.annotations.Url;
import io.headspin.hackathon.models.Site;

import static io.headspin.hackathon.reports.ReportLogger.log;

public class LaunchPage extends BasePage {

    @Inject
    @Url
    String url;

    @Inject
    Site site;


    public void launch() {
        log("launches site "+url);
        get(url);
    }

    public Site getSiteDetails() {
        Site siteDetails = site.toBuilder().title(title()).build();
        log("verifies site details "+siteDetails.toString());
        return siteDetails;
    }
}

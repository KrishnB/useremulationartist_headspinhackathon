package io.headspin.hackathon.pages;

import com.google.inject.Inject;
import io.headspin.hackathon.annotations.Url;
import io.headspin.hackathon.models.Site;

public class LaunchPage extends BasePage {

    @Inject
    @Url
    String url;

    @Inject
    Site site;

    public void launch() {
        get(url);
    }

    public Site getSiteDetails() {
        return site.toBuilder().title(title()).build();
    }

    public LaunchPage get() {
        return (LaunchPage) init(this);
    }
}

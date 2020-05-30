package io.headspin.hackathon.site;

import io.headspin.hackathon.pages.LaunchPage;

import static io.headspin.hackathon.pages.PageInitiator.getPage;

public class Launcher {

    public void launch() {
        LaunchPage launchPage = getPage(LaunchPage.class);
        launchPage.launch();
        launchPage.getSiteDetails().assertThatSiteIsUp();
    }
}

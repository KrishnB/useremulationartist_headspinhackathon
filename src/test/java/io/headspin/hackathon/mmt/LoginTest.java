package io.headspin.hackathon.mmt;


import io.headspin.hackathon.BaseTest;
import io.headspin.hackathon.TestGroups;
import io.headspin.hackathon.annotations.Log;
import io.headspin.hackathon.models.Site;
import io.headspin.hackathon.pages.LaunchPage;
import org.slf4j.Logger;
import org.testng.annotations.Test;

import static io.headspin.hackathon.pages.PageInitiator.getPage;

@Test(groups = TestGroups.HACKATHON)
public class LoginTest extends BaseTest {


    public void launchTest() {
        LaunchPage page = getPage(LaunchPage.class);
        page.launch();
        Site siteDetails = page.getSiteDetails();
    }

    public void launchTest1() {

    }
}

package io.headspin.hackathon;

import com.google.inject.Inject;
import com.google.inject.Injector;
import io.headspin.hackathon.assertions.SiteAssertions;
import io.headspin.hackathon.clients.SiteClient;
import io.headspin.hackathon.modules.BrowserModule;
import io.headspin.hackathon.modules.PageModule;
import io.headspin.hackathon.modules.PropertyModule;
import io.headspin.hackathon.modules.SiteModule;
import io.headspin.hackathon.pages.LaunchPage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Guice;

@Guice(modules = {PropertyModule.class, SiteModule.class})
public
class BaseTest {

    private WebDriver driver;

    @Inject
    private Injector parentInjector,  // Instantiates suite level objects, like env properties, site clients etc.
            driverInjector; // Instantiates singleton driver per test.

    @Inject
    SiteClient siteClient;

    @Inject
    SiteAssertions siteAssertions;

    @BeforeSuite(alwaysRun = true)
    public void verifyIfEnvIsAvailable() {
        siteClient.terminateIfSiteIsDown();
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(ITestContext iTestContext) {
        driverInjector = parentInjector.createChildInjector(new BrowserModule(),
                new PageModule()); //Lazy injection of driver and pages to support test parallelism
        driver = driverInjector.getInstance(WebDriver.class);
        launchSite();
        iTestContext.setAttribute(Constants.DRIVER_INJECTOR, driverInjector);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }


    protected <T> T getPage(Class<T> tClass) {
       return driverInjector.getInstance(tClass);
    }

    protected void launchSite() {
        LaunchPage launchPage = getPage(LaunchPage.class);
        launchPage.launch();
        siteAssertions.assertThatSiteIsLoadedSuccessfully(launchPage.getSiteDetails());
    }
}

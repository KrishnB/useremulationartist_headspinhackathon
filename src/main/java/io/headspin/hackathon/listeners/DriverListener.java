package io.headspin.hackathon.listeners;

import com.google.inject.Injector;
import com.google.inject.Module;
import io.headspin.hackathon.Constants;
import io.headspin.hackathon.modules.BrowserModule;
import io.headspin.hackathon.modules.PageModule;
import io.headspin.hackathon.modules.PropertyModule;
import io.headspin.hackathon.modules.SiteModule;
import io.headspin.hackathon.pages.LaunchPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.testng.*;

import java.util.Arrays;
import java.util.List;

public class DriverListener implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        Injector driverInjector = result.getTestContext().getSuite().getParentInjector().createChildInjector(setupModules());
        result.setAttribute(Constants.DRIVER_INJECTOR, driverInjector);
        result.setAttribute(Constants.PAGE_INJECTOR, driverInjector);
        launchSite(driverInjector);
    }

    protected void launchSite(Injector pageInjector) {
        LaunchPage launchPage = pageInjector.getInstance(LaunchPage.class);
        launchPage.launch();
        launchPage.getSiteDetails().assertThatSiteIsUp();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        quit(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        quit(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        quit(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        quit(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        quit(result);
    }


    public void quit(ITestResult result) {
        Injector driver = (Injector) result.getAttribute(Constants.DRIVER_INJECTOR);
        WebDriver driverInstance = driver.getInstance(WebDriver.class);
        Reporter.log("Quitting driver "+driverInstance.toString());
        driverInstance.quit();
    }

    private List<Module> setupModules() {
        return Arrays.asList(
                new SiteModule(),
                new PropertyModule(),
                new BrowserModule(),
                new PageModule());
    }


}

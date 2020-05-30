package io.headspin.hackathon.drivers.browserManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.headspin.hackathon.drivers.DriverManager;
import io.headspin.hackathon.drivers.Target;
import io.headspin.hackathon.properties.SystemProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager {
    @Override
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Override
    public WebDriver setupDriver() {
        setup();
        return launchDriver(new FirefoxDriver(browserOptions()));
    }

    @Override
    public void terminateDriver() {
        driver.get().quit();
    }

    @Override
    public FirefoxOptions browserOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        enableHeadless(firefoxOptions);
        return firefoxOptions;
    }

    private void enableHeadless(FirefoxOptions firefoxOptions) {
        if(SystemProperties.TARGET.equalsIgnoreCase(Target.HEADLESS.name().toLowerCase())) {
            firefoxOptions.setHeadless(Boolean.TRUE);
            firefoxOptions.addArguments(headlessArguments());
        }
    }

    @Override
    public WebDriver get() {
        setupDriver();
        return driver.get();
    }
}

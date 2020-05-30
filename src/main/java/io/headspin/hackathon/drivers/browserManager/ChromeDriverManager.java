package io.headspin.hackathon.drivers.browserManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.headspin.hackathon.drivers.DriverManager;
import io.headspin.hackathon.drivers.Target;
import io.headspin.hackathon.properties.SystemProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeDriverManager extends DriverManager {

    @Override
    public void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @Override
    public WebDriver createDriver() {
        setup();
        driver.set(new ChromeDriver(browserOptions()));
        driver.get().manage().window().maximize();
        return driver.get();
    }

    @Override
    public void terminateDriver() {
        driver.get().quit();
    }

    @Override
    public ChromeOptions browserOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        enableHeadless(chromeOptions);
        return chromeOptions;
    }

    private void enableHeadless(ChromeOptions chromeOptions) {
        if(SystemProperties.TARGET.equalsIgnoreCase(Target.HEADLESS.name().toLowerCase())) {
            chromeOptions.setHeadless(true);
            chromeOptions.addArguments(headlessArguments());
        }
    }

    @Override
    public WebDriver get() {
        createDriver();
        return driver.get();
    }
}

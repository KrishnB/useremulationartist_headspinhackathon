package io.headspin.hackathon.drivers;

import com.google.inject.Provider;
import io.headspin.hackathon.properties.SystemProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class DriverManager implements Driver, Provider<WebDriver> {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Override
    public WebDriver getDriver() {
        return driver.get();
    }

    public List<String> headlessArguments() {
        return Arrays.asList("disable-dev-shm-usage",
                "disable-gpu",
                "no-sandbox");
    }
}

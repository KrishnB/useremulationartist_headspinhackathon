package io.headspin.hackathon.drivers.browserManager;

import com.google.gson.Gson;
import io.headspin.hackathon.drivers.DriverManager;
import io.headspin.hackathon.drivers.config.HeadspinConfig;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HeadSpinDriverManager extends DriverManager {

    @Override
    public WebDriver get() {
        setupDriver();
        return driver.get();
    }



    @Override
    public WebDriver setupDriver() {
        HeadspinConfig headspinConfig = loadHeadspinConfig();
        RemoteWebDriver webDriver = new RemoteWebDriver(getUrl(headspinConfig), getCapabilities(headspinConfig));
        return launchDriver(webDriver);
    }

    @Override
    public void terminateDriver() {
        driver.get().quit();
    }

    @Override
    public AbstractDriverOptions browserOptions() {
        throw new UnsupportedOperationException();
    }

    private HeadspinConfig loadHeadspinConfig() {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("headspin.json");
        HeadspinConfig headspinConfig = new Gson().fromJson(new InputStreamReader(resourceAsStream), HeadspinConfig.class);
        return headspinConfig;
    }

    private Capabilities getCapabilities(HeadspinConfig headspinConfig) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(headspinConfig.getCaps().getBrowserName());
        capabilities.setCapability(CapabilityType.BROWSER_VERSION, headspinConfig.getCaps().getBrowserVersion());
        capabilities.setCapability("headspin:initialScreenSize", headspinConfig.getCaps().getScreenSize());
        return capabilities;
    }

    private URL getUrl(HeadspinConfig headspinConfig) {
        try {
            return new URL(headspinConfig.getUrl());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Invalid config");
    }
}

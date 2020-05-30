package io.headspin.hackathon.drivers.wait;

import com.google.inject.Inject;
import com.google.inject.Provider;
import io.headspin.hackathon.annotations.WaitDuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits implements Provider<WebDriverWait> {
    private WebDriverWait webDriverWait;


    @Inject
    public Waits(WebDriver webDriver, @WaitDuration String waitDuration) {
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(Long.parseLong(waitDuration)));
    }

    @Override
    public WebDriverWait get() {
        return webDriverWait;
    }
}

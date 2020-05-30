package io.headspin.hackathon.interceptors.screenshot;

import com.google.inject.Inject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotTaker {

    @Inject
    WebDriver webDriver;

    public byte[] saveScreenshot() {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }
}

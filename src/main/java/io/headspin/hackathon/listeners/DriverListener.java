package io.headspin.hackathon.listeners;

import com.google.inject.Injector;
import io.headspin.hackathon.modules.BrowserModule;
import io.headspin.hackathon.modules.PageModule;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.util.List;

public class DriverListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
//        Injector parentInjector = result.getTestContext().getSuite().getParentInjector();
//        Injector driverInjector = parentInjector.createChildInjector(new BrowserModule(),
//                new PageModule());
//        WebDriver instance = driverInjector.getInstance(WebDriver.class);
    }
}

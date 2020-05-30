package io.headspin.hackathon.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;

import java.util.List;

public interface Driver {

    void setup();

    WebDriver setupDriver();

    void terminateDriver();

    WebDriver getDriver();

    AbstractDriverOptions browserOptions();

    List<String> headlessArguments();
}

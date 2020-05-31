package io.headspin.hackathon.modules;

import com.google.inject.AbstractModule;
import io.headspin.hackathon.drivers.Browser;
import io.headspin.hackathon.drivers.Target;
import io.headspin.hackathon.drivers.browserManager.HeadSpinDriverManager;
import io.headspin.hackathon.drivers.wait.Waits;
import io.headspin.hackathon.drivers.browserManager.ChromeDriverManager;
import io.headspin.hackathon.drivers.browserManager.FirefoxDriverManager;
import io.headspin.hackathon.properties.SystemProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedHashMap;
import java.util.Map;

public class BrowserModule extends AbstractModule {

    @Override
    public void configure() {
        if(SystemProperties.TARGET.equals(Target.HEADSPIN.name().toLowerCase())) {
            bind(WebDriver.class).toProvider(HeadSpinDriverManager.class).asEagerSingleton();
        }else {
            bind(WebDriver.class).toProvider(getBrowserManager()).asEagerSingleton();
        }
        bind(WebDriverWait.class).toProvider(Waits.class).asEagerSingleton();
    }


    private Class getBrowserManager() {
        Browser browser = Browser.valueOf(SystemProperties.BROWSER.toUpperCase());
        return browserProviderMap().get(browser);
    }

    private Map<Browser, Class> browserProviderMap() {
        Map<Browser, Class> browserProviderMap = new LinkedHashMap<>();
        browserProviderMap.put(Browser.CHROME, ChromeDriverManager.class);
        browserProviderMap.put(Browser.FIREFOX, FirefoxDriverManager.class);
        return browserProviderMap;
    }
}

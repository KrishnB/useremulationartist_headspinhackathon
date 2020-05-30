package io.headspin.hackathon;

import com.google.inject.Inject;
import com.google.inject.Injector;
import io.headspin.hackathon.assertions.SiteAssertions;
import io.headspin.hackathon.clients.SiteClient;
import io.headspin.hackathon.modules.BrowserModule;
import io.headspin.hackathon.modules.PageModule;
import io.headspin.hackathon.modules.PropertyModule;
import io.headspin.hackathon.modules.SiteModule;
import io.headspin.hackathon.pages.LaunchPage;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.*;

@Guice(modules = {SiteModule.class, PropertyModule.class})
public class BaseTest {

}

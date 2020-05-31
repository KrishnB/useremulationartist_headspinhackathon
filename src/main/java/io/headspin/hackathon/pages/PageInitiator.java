package io.headspin.hackathon.pages;

import com.google.inject.Injector;
import io.headspin.hackathon.site.Constants;
import org.testng.Reporter;

public class PageInitiator {

    public static <T extends BasePage> T getPage(Class<T> tClass) {
        Injector pageInjector = (Injector) Reporter.getCurrentTestResult()
                .getAttribute(Constants.PAGE_INJECTOR);
        T page = pageInjector.getInstance(tClass);
        return (T) page.init(page);
    }
}

package io.headspin.hackathon;

import com.google.inject.Injector;
import org.testng.Reporter;

public class PageInitiator {

    public static <T> T getPage(Class<T> tClass) {
        System.out.println(Reporter.getCurrentTestResult().getName());
        Injector pageInjector = (Injector) Reporter.getCurrentTestResult()
                .getAttribute(Constants.PAGE_INJECTOR);
        return pageInjector.getInstance(tClass);
    }
}

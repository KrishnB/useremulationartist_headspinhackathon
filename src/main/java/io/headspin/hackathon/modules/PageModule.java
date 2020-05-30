package io.headspin.hackathon.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import io.headspin.hackathon.annotations.Screenshot;
import io.headspin.hackathon.interceptors.screenshot.ScreenshotInterceptor;
import io.headspin.hackathon.interceptors.screenshot.ScreenshotTaker;

import static com.google.inject.matcher.Matchers.annotatedWith;
import static com.google.inject.matcher.Matchers.any;

public class PageModule extends AbstractModule {

    @Inject
    ScreenshotTaker screenshotTaker;

    @Override
    public void configure() {
        ScreenshotInterceptor screenshotInterceptor = new ScreenshotInterceptor();
        requestInjection(screenshotInterceptor);
        bindInterceptor(any(), annotatedWith(Screenshot.class), screenshotInterceptor);
    }
}

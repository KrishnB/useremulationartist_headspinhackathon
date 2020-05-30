package io.headspin.hackathon.interceptors.screenshot;

import com.google.inject.Inject;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class ScreenshotInterceptor implements MethodInterceptor {

    @Inject
    ScreenshotTaker screenshotTaker;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        screenshotTaker.saveScreenshot();
        return invocation.proceed();
    }
}

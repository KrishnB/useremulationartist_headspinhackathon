package io.headspin.hackathon.reports;

import org.testng.Reporter;

public class ReportLogger {

    public static void log(String message) {
        Reporter.log(message, true);
    }
}

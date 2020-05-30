package io.headspin.hackathon.listeners;

import io.headspin.hackathon.io.LogManager;
import io.headspin.hackathon.site.Constants;
import org.apache.commons.io.FileUtils;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class ReportListener implements IReporter {

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        suites.forEach(suite -> {
            suite.getResults().entrySet().forEach(entry -> {
                entry.getValue().getTestContext().getPassedTests().getAllResults().forEach(iTestResult -> {
                    List<String> logs = Reporter.getOutput(iTestResult);
                    String logFolder = (String) suite.getAttribute(Constants.LOG_FOLDER);
                    LogManager.writeLog(logFolder, iTestResult.getName(),logs);
                });
            });
        });
    }
}

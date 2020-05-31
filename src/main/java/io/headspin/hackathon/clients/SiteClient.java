package io.headspin.hackathon.clients;

import com.google.inject.Inject;
import io.headspin.hackathon.annotations.Url;
import io.headspin.hackathon.exceptions.UnReachableSiteException;
import io.qameta.allure.Step;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

import java.io.IOException;

import static io.headspin.hackathon.reports.ReportLogger.log;

public class SiteClient {

    @Inject
    @Url
    private String url;


    private OkHttpClient okHttpClient;

    public SiteClient() {
        okHttpClient = new OkHttpClient();
    }

    @Step("Checking if site is down")
    public boolean isSiteDown() {
        try {
            Request siteRequest = buildBasicRequest();
            log("Creating a new site request" + siteRequest.toString());
            Response execute = okHttpClient.newCall(buildBasicRequest())
                    .execute();
            return !execute.isSuccessful();
        } catch (IOException e) {
            log("Failed to execute site request");
            e.printStackTrace();
        }
        return true;
    }


    public void terminateIfSiteIsDown() {
        try {
            if (isSiteDown()) {
                throw new UnReachableSiteException(url);
            }
            log("Proceeding ahead as env is available");
        } catch (UnReachableSiteException e) {
            log("Unable to reach site, terminating build");
            System.exit(1);
        }
    }

    private Request buildBasicRequest() {
        return new Builder().url(url).build();
    }
}

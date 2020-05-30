package io.headspin.hackathon.clients;

import com.google.inject.Inject;
import io.headspin.hackathon.annotations.Url;
import io.headspin.hackathon.exceptions.UnReachableSiteException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

import java.io.IOException;

public class SiteClient {

    @Inject
    @Url
    String url;

    private OkHttpClient okHttpClient;
    public SiteClient() {
        okHttpClient = new OkHttpClient();
    }

    public boolean isSiteDown() {
        try {
            Response execute = okHttpClient.newCall(buildBasicRequest())
                    .execute();
            return !execute.isSuccessful();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


    public void terminateIfSiteIsDown() {
        try {
            if(isSiteDown()) {
                throw new UnReachableSiteException(url);
            }
        } catch (UnReachableSiteException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private Request buildBasicRequest() {
        return new Builder().url(url).build();
    }
}

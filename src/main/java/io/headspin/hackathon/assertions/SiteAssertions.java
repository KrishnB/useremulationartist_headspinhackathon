package io.headspin.hackathon.assertions;

import com.google.inject.Inject;
import io.headspin.hackathon.models.Site;

import static org.assertj.core.api.Assertions.assertThat;

public class SiteAssertions {
    @Inject
    Site expSiteDetails;

    public void assertThatSiteIsLoadedSuccessfully(Site siteDetails) {
        assertThat(siteDetails.equals(expSiteDetails.get())).isTrue();
    }
}

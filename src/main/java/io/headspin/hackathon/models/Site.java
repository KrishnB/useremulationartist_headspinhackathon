package io.headspin.hackathon.models;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import lombok.*;

import java.util.Objects;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

@Getter @Setter @Builder(toBuilder = true) @NoArgsConstructor @AllArgsConstructor
public class Site implements Entity<Site>, Provider<Site> {
    private String title;

    @Inject
    Logger logger;

    @Inject
    @Named("title") String siteTitle;

    @Override
    public Site init() {
        return this.toBuilder()
                .title("MakeMyTrip")
                .build();
    }

    public void assertThatSiteIsUp() {
        assertThat(title).startsWith(siteTitle);
    }

    @Override
    public Site get() {
        return init();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Site site = (Site) o;
        return Objects.equals(title, site.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "{"
                + "\"title\":\"" + title + "\""
                + "}}";
    }

}

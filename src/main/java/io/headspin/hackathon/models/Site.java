package io.headspin.hackathon.models;

import com.google.inject.Provider;
import lombok.*;

import java.util.Objects;

@Getter @Setter @Builder(toBuilder = true) @NoArgsConstructor @AllArgsConstructor
public class Site implements Entity<Site>, Provider<Site> {
    private String title;

    @Override
    public Site init() {
        return this.toBuilder()
                .title("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday")
                .build();
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

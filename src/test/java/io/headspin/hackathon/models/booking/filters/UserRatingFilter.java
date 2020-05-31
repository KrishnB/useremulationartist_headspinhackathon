package io.headspin.hackathon.models.booking.filters;

import io.headspin.hackathon.models.Entity;
import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true) @NoArgsConstructor
@AllArgsConstructor
public class UserRatingFilter implements Entity<UserRatingFilter> {
    private String userRating;
    @Override
    public UserRatingFilter init() {
        return this.toBuilder()
                .userRating("4 & above (Very Good)")
                .build();

    }
}

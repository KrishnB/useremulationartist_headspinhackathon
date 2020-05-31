package io.headspin.hackathon.models.booking.filters;

import io.headspin.hackathon.models.Entity;
import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true) @NoArgsConstructor
@AllArgsConstructor
public class PricePerNightFilter implements Entity<PricePerNightFilter> {
    private int min;
    private int max;
    private int moveBy;

    @Override
    public PricePerNightFilter init() {
        return this.toBuilder()
                .min(1000)
                .max(30000)
                .moveBy(1000/500)
                .build();
    }
}

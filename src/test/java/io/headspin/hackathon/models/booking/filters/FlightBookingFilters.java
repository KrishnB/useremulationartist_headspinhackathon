package io.headspin.hackathon.models.booking.filters;


import io.headspin.hackathon.models.Entity;
import io.headspin.hackathon.models.booking.BookingFilters;
import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true) @NoArgsConstructor
@AllArgsConstructor
public class FlightBookingFilters extends BookingFilters implements Entity<FlightBookingFilters> {
    private PricePerNightFilter pricePerNightFilter;
    private UserRatingFilter userRatingFilter;

    @Override
    public FlightBookingFilters init() {
        return this.toBuilder()
                .pricePerNightFilter(new PricePerNightFilter().init())
                .userRatingFilter(new UserRatingFilter().init())
                .build();
    }
}

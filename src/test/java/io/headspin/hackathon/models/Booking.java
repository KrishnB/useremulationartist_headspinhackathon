package io.headspin.hackathon.models;

import io.headspin.hackathon.models.booking.BookingPlanner;
import io.headspin.hackathon.models.booking.BookingType;
import io.headspin.hackathon.models.booking.planner.HotelBookingPlanner;
import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true) @NoArgsConstructor
@AllArgsConstructor
public class Booking implements Entity<Booking> {
    private BookingType bookingType;
    private BookingPlanner bookingPlanner;

    @Override
    public Booking init() {
        BookingType bookingType = BookingType.HOTELS;
        return this.toBuilder()
                .bookingType(bookingType)
                .bookingPlanner(bookingType.getBookingPlanner())
                .build();
    }
}

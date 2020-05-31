package io.headspin.hackathon.models.booking;

import io.headspin.hackathon.models.Entity;
import lombok.*;
import org.joda.time.DateTime;

import java.util.Date;

@Getter
@Setter
@Builder(toBuilder = true) @NoArgsConstructor
@AllArgsConstructor
public class BookingPlanner implements Entity<BookingPlanner> {

    protected DateTime checkin;
    protected DateTime checkout;
    protected String travelingFor;

    @Override
    public BookingPlanner init() {
        return this.toBuilder()
                .checkin(new DateTime())
                .checkout(new DateTime().plusDays(1))
                .travelingFor("work")
                .build();
    }
}

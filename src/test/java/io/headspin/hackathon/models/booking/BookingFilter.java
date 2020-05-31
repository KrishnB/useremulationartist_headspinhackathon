package io.headspin.hackathon.models.booking;

import io.headspin.hackathon.models.Entity;
import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true) @NoArgsConstructor
@AllArgsConstructor
public class BookingFilter implements Entity<BookingFilter> {
    @Override
    public BookingFilter init() {
        return null;
    }
}

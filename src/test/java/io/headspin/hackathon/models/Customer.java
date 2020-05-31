package io.headspin.hackathon.models;

import lombok.*;

@Getter @Setter @Builder(toBuilder = true) @NoArgsConstructor @AllArgsConstructor
public class Customer implements Entity<Customer> {
    private Credentials credentials;
    private Booking bookingDetails;

    @Override
    public Customer init() {
        return this.toBuilder()
                .credentials(new Credentials().init())
                .bookingDetails(new Booking().init())
                .build();
    }
}

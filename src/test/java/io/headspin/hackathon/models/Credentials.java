package io.headspin.hackathon.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Credentials implements Entity<Credentials> {
    private String username;
    private String password;

    @Override
    public Credentials init() {
        return this.toBuilder()
                .username("headspinautomation@mailnd7.com")
                .password("headspin123$")
                .build();
    }
}

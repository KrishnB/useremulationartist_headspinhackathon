package io.headspin.hackathon.models.booking;

import io.headspin.hackathon.models.booking.planner.FlightBookingPlanner;
import io.headspin.hackathon.models.booking.planner.HotelBookingPlanner;

public enum BookingType {
    FLIGHTS(new FlightBookingPlanner().init()),
    HOTELS(new HotelBookingPlanner().init());

    private BookingPlanner bookingPlanner;

    BookingType(BookingPlanner bookingPlanner) {
        this.bookingPlanner = bookingPlanner;
    }

    public BookingPlanner getBookingPlanner() {
        return bookingPlanner;
    }
}

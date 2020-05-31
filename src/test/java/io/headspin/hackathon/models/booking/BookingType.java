package io.headspin.hackathon.models.booking;

import io.headspin.hackathon.models.booking.filters.FlightBookingFilters;
import io.headspin.hackathon.models.booking.filters.HotelBookingFilters;
import io.headspin.hackathon.models.booking.planner.FlightBookingPlanner;
import io.headspin.hackathon.models.booking.planner.HotelBookingPlanner;

public enum BookingType {
    FLIGHTS(new FlightBookingPlanner().init(), new FlightBookingFilters().init()),
    HOTELS(new HotelBookingPlanner().init(), new HotelBookingFilters().init());

    private BookingPlanner bookingPlanner;
    private BookingFilters bookingFilters;

    BookingType(BookingPlanner bookingPlanner, BookingFilters bookingFilters) {
        this.bookingPlanner = bookingPlanner;
        this.bookingFilters = bookingFilters;
    }

    public BookingPlanner getBookingPlanner() {
        return bookingPlanner;
    }

    public BookingFilters getBookingFilters() {
        return bookingFilters;
    }
}

package io.headspin.hackathon.mmt.pages;

import io.headspin.hackathon.models.Booking;
import io.headspin.hackathon.models.booking.BookingFilters;
import io.headspin.hackathon.pages.BasePage;

public class ListingPage extends BasePage<HotelListingPage> {

    public ListingPage applyFilters(BookingFilters filter) {
        throw new UnsupportedOperationException();
    }

    public DetailsPage selectListing(Booking booking) {
        throw new UnsupportedOperationException();
    }
}

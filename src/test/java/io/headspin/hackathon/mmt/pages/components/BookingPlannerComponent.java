package io.headspin.hackathon.mmt.pages.components;

import com.google.inject.Inject;
import io.headspin.hackathon.mmt.pages.ListingPage;
import io.headspin.hackathon.mmt.pages.components.planner.HotelBookingPlannerComponent;
import io.headspin.hackathon.models.booking.BookingPlanner;
import io.headspin.hackathon.models.booking.BookingType;
import io.headspin.hackathon.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.headspin.hackathon.pages.PageInitiator.getPage;

public class BookingPlannerComponent extends BasePage<BookingPlannerComponent> {



    @Inject
    private HotelBookingPlannerComponent hotelBookingPlannerComponent;

    public BookingPlannerComponent getBookingPlannerComponent(BookingType bookingType) {
        return bookingPlannerComponents().get(bookingType);
    }

    public ListingPage makeBooking(BookingPlanner bookingPlanner) {
        throw new UnsupportedOperationException();
    }


    public Map<BookingType, BookingPlannerComponent> bookingPlannerComponents() {
        Map<BookingType, BookingPlannerComponent> bookingPlannerComponentMap = new HashMap<>();
        bookingPlannerComponentMap.put(BookingType.HOTELS, getPage(HotelBookingPlannerComponent.class));
        return bookingPlannerComponentMap;
    }
}

package io.headspin.hackathon.mmt.pages;

import com.google.inject.Inject;
import io.headspin.hackathon.mmt.pages.components.BookingFilterComponent;
import io.headspin.hackathon.models.Booking;
import io.headspin.hackathon.models.booking.BookingFilters;
import io.headspin.hackathon.models.booking.filters.HotelBookingFilters;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static io.headspin.hackathon.pages.PageInitiator.getPage;

public class HotelListingPage extends ListingPage {

    @FindBy(className = "mapCont")
    private WebElement map;

    @FindBy(className = "mapClose")
    private WebElement mapClose;

    @FindBy(css = "div[id ^='Listing_hotel']")
    private List<WebElement> hotels;

    private By hotelName = By.cssSelector("#hlistpg_hotel_name span[id ^='htl_id']");
    private By hotelRating = By.cssSelector("#hlistpg_hotel_name span[id ^='hlistpg_hotel_star_rating']");

    @Inject
    BookingFilterComponent bookingFilterComponent;


    @Override
    public ListingPage applyFilters(BookingFilters filter) {
        handleMapToolTip();
        bookingFilterComponent
                .getPricePerNightBookingFilterComponent()
                .applyPricePerNightFilter(((HotelBookingFilters)filter).getPricePerNightFilter())
                .getUserRatingBookingFilterComponent()
                .applyUserRating(((HotelBookingFilters)filter).getUserRatingFilter());
        return this;
    }

    @Step("Selecting a hotel from the list")
    public HotelDetailsPage selectListing(Booking booking) {
        waitForElementsToBeDisplayed(hotels);
        try {
            WebElement hotel;
            if(hotels.size()>5) {
                hotel = hotels.get(4);
            } else {
                hotel  = hotels.get(0);
            }
            booking.setHotelName(hotel.findElement(hotelName).getText());
            booking.setRating(hotel.findElement(hotelRating).getAttribute("content"));
            click(hotel, "hotel");
            switchTab();
        } catch (Exception e) {
            throw new RuntimeException("No hotels listed");
        }
        return getPage(HotelDetailsPage.class);
    }

    private void handleMapToolTip() {
        click(map);
        click(mapClose);
    }
}

package io.headspin.hackathon.mmt.pages.components.planner;

import io.headspin.hackathon.mmt.pages.HotelListingPage;
import io.headspin.hackathon.mmt.pages.ListingPage;
import io.headspin.hackathon.mmt.pages.components.BookingPlannerComponent;
import io.headspin.hackathon.models.booking.BookingPlanner;
import io.headspin.hackathon.models.booking.planner.HotelBookingPlanner;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.IntStream;

import static io.headspin.hackathon.pages.PageInitiator.getPage;

public class HotelBookingPlannerComponent extends BookingPlannerComponent {

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(css = "input[placeholder='Enter city/ Hotel/ Area/ Building']")
    private WebElement hotelSearch;

    @FindBy(css = "ul[role='listbox'] > li p[class ^=\"locusLabel\"]")
    private WebElement suggestion;

    @FindBy(css = "span[data-cy='travelForText']")
    private WebElement travelFor;

    @FindBy(id = "checkin")
    private WebElement checkin;

    @FindBy(css = "p[data-cy='roomGuestCount']")
    private WebElement guest;

    @FindBy(css = "button[data-cy='addAnotherRoom']")
    private WebElement addAnotherRoomButton;

    @FindBy(css = "button[data-cy='submitGuest']")
    private WebElement apply;

    @FindBy(css = "ul[data-cy='adultCount'] li")
    private List<WebElement> guestCount;

    @FindBy(css = ".travelForPopup li[data-cy]")
    private List<WebElement> travelReasons;

    @FindBy(css = "button[id=\"hsw_search_button\"]")
    private WebElement search;

    @Step("Creating a new booking")
    public ListingPage makeBooking(BookingPlanner hotelBookingPlanner) {
        searchFor(((HotelBookingPlanner)hotelBookingPlanner).getSearchFor());
        travelReason(hotelBookingPlanner.getTravelingFor());
        guests(((HotelBookingPlanner) hotelBookingPlanner).getGuests(), ((HotelBookingPlanner) hotelBookingPlanner).getRooms());
        search();
        return getPage(HotelListingPage.class);
    }

    private void searchFor(String searchFor) {
        click(city, "city");
        type(hotelSearch, searchFor, "city");
        click(suggestion, "first suggestion");
    }

    private void guests(int guests, int rooms) {
        click(guest, "guest");
        IntStream.range(1, rooms+1).forEach(room -> {
            if(room>1) {
                click(addAnotherRoomButton, "add another room");
            }
            findFromList(guestCount, "data-cy", String.valueOf(guests)).click();
        });
        click(apply, "apply guests count");
    }

    private void travelReason(String travelReason) {
       try {
           click(travelFor, "travelling for reason");
           findFromList(travelReasons, "data-cy", travelReason)
                   .click();
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    public void search() {
        click(search, "search");
    }
}

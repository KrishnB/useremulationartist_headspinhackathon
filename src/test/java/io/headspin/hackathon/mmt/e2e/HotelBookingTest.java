package io.headspin.hackathon.mmt.e2e;

import com.google.inject.Inject;
import io.headspin.hackathon.BaseTest;
import io.headspin.hackathon.TestGroups;
import io.headspin.hackathon.mmt.pages.HotelListingPage;
import io.headspin.hackathon.mmt.pages.ListingPage;
import io.headspin.hackathon.models.Customer;
import io.headspin.hackathon.mmt.pages.HomePage;
import io.headspin.hackathon.models.booking.BookingType;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import static io.headspin.hackathon.pages.PageInitiator.getPage;

@Test(groups = TestGroups.HACKATHON)
@Epic("Booking")
@Feature("Book any hotel")
public class HotelBookingTest extends BaseTest {

    @Inject
    Customer customerProvider;

    @Description("Book a hotel using valid customer booking details")
    public void customerShouldBeAbleToBookAHotel() throws InterruptedException {
        HomePage homePage = getPage(HomePage.class);
        Customer customer = customerProvider.init();
        homePage.getUserSectionComponent()
                .navToLogin()
                .login(customer.getCredentials())
                .getMenuComponent()
                .navToMenu(customer.getBookingDetails().getBookingType())
                .getBookingPlannerComponent(customer.getBookingDetails().getBookingType())
                .makeBooking(customer.getBookingDetails().getBookingType().getBookingPlanner())
                .applyFilters(customer.getBookingDetails().getBookingFilters())
                .selectListing(customer.getBookingDetails())
                .bookNow(customer.getBookingDetails());

    }
}

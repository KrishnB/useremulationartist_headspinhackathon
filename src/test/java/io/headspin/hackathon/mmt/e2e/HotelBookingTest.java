package io.headspin.hackathon.mmt.e2e;

import com.google.inject.Inject;
import io.headspin.hackathon.BaseTest;
import io.headspin.hackathon.TestGroups;
import io.headspin.hackathon.models.Customer;
import io.headspin.hackathon.mmt.pages.HomePage;
import io.headspin.hackathon.models.booking.BookingType;
import org.testng.annotations.Test;

import static io.headspin.hackathon.pages.PageInitiator.getPage;

@Test(groups = TestGroups.HACKATHON)
public class HotelBookingTest extends BaseTest {

    @Inject
    Customer customerProvider;

    public void bookAHotel() {
        HomePage homePage = getPage(HomePage.class);
        Customer customer = customerProvider.init();
        homePage.getUserSectionComponent()
                .navToLogin()
                .login(customer.getCredentials())
                .getMenuComponent()
                .navToMenu(customer.getBookingDetails().getBookingType())
                .getBookingPlannerComponent(customer.getBookingDetails().getBookingType())
                .makeBooking(customer.getBookingDetails().getBookingType().getBookingPlanner());
        // Login
        // Select hotel from offerings
        // Add Trip Details
        // Apply filters : min 1000rs and user rating 4 & above
        // Select 5th hotel from list
        // select first room in hotel details
        // Enter traveller info
        // Select any two request options
        // Capture and verify booking summary
    }
}

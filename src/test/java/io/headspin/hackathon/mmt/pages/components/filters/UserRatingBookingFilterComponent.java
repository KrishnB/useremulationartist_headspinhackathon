package io.headspin.hackathon.mmt.pages.components.filters;

import io.headspin.hackathon.mmt.pages.components.BookingFilterComponent;
import io.headspin.hackathon.models.booking.filters.UserRatingFilter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static io.headspin.hackathon.pages.PageInitiator.getPage;

public class UserRatingBookingFilterComponent extends BookingFilterComponent {

    @FindBy(css = "#hlistpg_fr_user_rating span[class='checkmarkOuter'] label")
    private List<WebElement> userRatings;

    public BookingFilterComponent applyUserRating(UserRatingFilter userRatingFilter) {
        WebElement userRating = findFromList(userRatings, userRatingFilter.getUserRating());
        click(userRating, "userRating "+userRatingFilter.getUserRating());
        return getPage(BookingFilterComponent.class);
    }
}


package io.headspin.hackathon.mmt.pages.components.filters;

import io.headspin.hackathon.mmt.pages.components.BookingFilterComponent;
import io.headspin.hackathon.models.booking.filters.PricePerNightFilter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static io.headspin.hackathon.pages.PageInitiator.getPage;

public class PricePerNightBookingFilterComponent extends BookingFilterComponent {

    @FindBy(css = "span[style $='left: 0%;'] div[class='input-range__slider']")
    private WebElement min;

    @FindBy(css = "span[style $='left: 100%;'] div[class='input-range__slider']")
    private WebElement max;

    public BookingFilterComponent applyPricePerNightFilter(PricePerNightFilter pricePerNightFilter) {
            setAttribute(min, "aria-valuenow", String.valueOf(pricePerNightFilter.getMoveBy()));
        return getPage(BookingFilterComponent.class);
    }
}

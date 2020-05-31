package io.headspin.hackathon.mmt.pages.components;

import com.google.inject.Inject;
import io.headspin.hackathon.mmt.pages.components.filters.PricePerNightBookingFilterComponent;
import io.headspin.hackathon.mmt.pages.components.filters.UserRatingBookingFilterComponent;
import io.headspin.hackathon.pages.BasePage;
import io.qameta.allure.Step;

import static io.headspin.hackathon.pages.PageInitiator.getPage;

public class BookingFilterComponent extends BasePage<BookingFilterComponent> {

    @Step("Adding price per night filter")
    public PricePerNightBookingFilterComponent getPricePerNightBookingFilterComponent() {
        return getPage(PricePerNightBookingFilterComponent.class);
    }

    @Step("Adding user rating filter")
    public UserRatingBookingFilterComponent getUserRatingBookingFilterComponent() {
        return getPage(UserRatingBookingFilterComponent.class);
    }
}

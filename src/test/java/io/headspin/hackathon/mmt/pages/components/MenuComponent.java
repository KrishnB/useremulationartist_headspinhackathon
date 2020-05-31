package io.headspin.hackathon.mmt.pages.components;

import io.headspin.hackathon.models.booking.BookingType;
import io.headspin.hackathon.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static io.headspin.hackathon.pages.PageInitiator.getPage;

public class MenuComponent extends BasePage {

    @FindBy(css = "li[data-cy^=\"menu\"]")
    private List<WebElement> menuItems;

    public BookingPlannerComponent navToMenu(BookingType bookingType) {
        init(this);
        click(findMenuItem(bookingType.name()), bookingType.name().toLowerCase());
        return getPage(BookingPlannerComponent.class);
    }
    public BookingPlannerComponent navToFlights() {
        return navToMenu(BookingType.FLIGHTS);
    }

    public BookingPlannerComponent navToHotels() {
        return navToMenu(BookingType.HOTELS);
    }

    private WebElement findMenuItem(String menuItem) {
        return findFromList(menuItems, "data-cy", menuItem).findElement(By.tagName("a"));
    }
}

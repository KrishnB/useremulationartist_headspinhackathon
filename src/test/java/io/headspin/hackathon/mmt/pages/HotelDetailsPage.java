package io.headspin.hackathon.mmt.pages;

import io.headspin.hackathon.models.Booking;
import io.headspin.hackathon.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class HotelDetailsPage extends DetailsPage {

    @FindBy(id = "detpg_hotel_name")
    private WebElement hotelName;

    @FindBy(id = "detpg_headerright_book_now")
    private WebElement bookNow;

    @Step("booking hotel now")
    public void bookNow(Booking booking) {
        sleep();
        waitForElementToBePresent(hotelName);
        String hotel = text(hotelName);
        booking.assertHotelNameIsCorrect(hotel);
        click(bookNow, "bookNow");
    }
}

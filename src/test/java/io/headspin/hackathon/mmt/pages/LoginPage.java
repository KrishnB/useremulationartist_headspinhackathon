package io.headspin.hackathon.mmt.pages;

import io.headspin.hackathon.models.Credentials;
import io.headspin.hackathon.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static io.headspin.hackathon.pages.PageInitiator.getPage;

public class LoginPage extends BasePage<LoginPage> {

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(css = "button[data-cy='continueBtn']")
    private WebElement continueBtn;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "button[data-cy='login']")
    private WebElement loginBtn;

    public HomePage login(Credentials credentials) {
        type(username, credentials.getUsername(), "username");
        click(continueBtn, "continue");
        type(password, credentials.getPassword(), "password");
        click(loginBtn, "login");
        sleep();
        return getPage(HomePage.class);
    }


}

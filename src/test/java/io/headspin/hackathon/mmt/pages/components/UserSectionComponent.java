package io.headspin.hackathon.mmt.pages.components;

import io.headspin.hackathon.mmt.pages.LoginPage;
import io.headspin.hackathon.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static io.headspin.hackathon.pages.PageInitiator.getPage;

public class UserSectionComponent extends BasePage<UserSectionComponent> {

    @FindBy(css = "li[data-cy='account']")
    private WebElement account;

    @FindBy(css = "li[data-cy='mmtDoubleBlack']")
    private WebElement mmtDoubleBlack;

    @FindBy(css = "li[data-cy='myTrips']")
    private WebElement myTrips;

    @FindBy(css = "li[data-cy='support']")
    private WebElement support;

    @FindBy(css = "li[data-cy='myBiz']")
    private WebElement myBiz;

    public LoginPage navToLogin() {
        log("clicks on account");
        click(account);
        return getPage(LoginPage.class);
    }
}

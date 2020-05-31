package io.headspin.hackathon.mmt.pages.components;

import io.headspin.hackathon.mmt.pages.LoginPage;
import io.headspin.hackathon.pages.BasePage;
import io.qameta.allure.Step;
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

    @Step("Navigating to login")
    public LoginPage navToLogin() {
        click(account, "account");
        return getPage(LoginPage.class);
    }
}

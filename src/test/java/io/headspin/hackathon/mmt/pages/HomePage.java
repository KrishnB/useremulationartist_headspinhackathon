package io.headspin.hackathon.mmt.pages;

import com.google.inject.Inject;
import io.headspin.hackathon.mmt.pages.components.MenuComponent;
import io.headspin.hackathon.mmt.pages.components.UserSectionComponent;
import io.headspin.hackathon.pages.BasePage;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;
import org.testng.annotations.Guice;

import static io.headspin.hackathon.pages.PageInitiator.getPage;

@Setter
public class HomePage extends BasePage<HomePage> {

    @Step("Navigating to user section")
    public UserSectionComponent getUserSectionComponent() {
        log("navigates to user section");
        return getPage(UserSectionComponent.class);
    }

    @Step("Navigating to menu section")
    public MenuComponent getMenuComponent() {
        log("navigates to menu section");
        return getPage(MenuComponent.class);
    }
}

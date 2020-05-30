package io.headspin.hackathon.pages;

import com.google.inject.Inject;
import io.headspin.hackathon.annotations.Log;
import io.headspin.hackathon.annotations.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

public abstract class BasePage<T> implements PageActions<T> {

    @Inject
    WebDriver webDriver;

    @Inject
    WebDriverWait webDriverWait;

    public BasePage() {
        init((T) this);
    }

    public T init(T page) {
        PageFactory.initElements(webDriver, page);
        return page;
    }

    @Override
    public void get(String url) {
        webDriver.get(url);
    }

    @Override @Screenshot
    public void click(WebElement element) {
        waitForElementToBePresent(element);
        element.click();
    }

    @Override @Screenshot
    public void type(WebElement element, String textToType) {
        waitForElementToBePresent(element);
        click(element);
        element.sendKeys(textToType);
    }

    @Override
    public String value(WebElement element) {
        waitForElementToBePresent(element);
        return element.getAttribute("value");
    }

    public void switchToFrame(String frameId) {
        webDriver.switchTo().frame(frameId);
    }

    public String title() {
        return webDriver.getTitle();
    }

    @Override
    public T refresh(T page) {
        return init(page);
    }


    public String text(WebElement webElement) {
        return waitForElementToBePresent(webElement).getText();
    }

    public WebElement waitForElementToBePresent(WebElement webElement) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }


    public Boolean waitForFrameToLoad(String frameId) {

        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
        return true;
    }

    public Boolean waitForFrameToLoad(Integer index) {
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
        return true;
    }

    public void switchToDefaultContent() {
        webDriver.switchTo().defaultContent();
    }
}

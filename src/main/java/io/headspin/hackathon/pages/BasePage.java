package io.headspin.hackathon.pages;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import io.headspin.hackathon.annotations.Screenshot;
import io.headspin.hackathon.reports.ReportLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Optional;

public abstract class BasePage<T> implements PageActions<T> {

    @Inject
    WebDriver webDriver;

    @Inject
    WebDriverWait webDriverWait;

    @Inject
    @Named("persona")
    private String persona;

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

    @Override
    @Screenshot
    public void click(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    @Screenshot
    public void click(WebElement element, String filedToLog) {
        log(String.format("clicks on %s", filedToLog));
        click(element);
    }

    @Override
    @Screenshot
    public void type(WebElement element, String textToType) {
        waitForElementToBePresent(element);
        click(element);
        element.sendKeys(textToType);
    }

    @Screenshot
    public void type(WebElement element, String textToType, String fieldNameToLog) {
        log(String.format("enters %s as %s", fieldNameToLog, textToType));
        type(element, textToType);
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

    public WebElement waitForElementToBeClickable(WebElement webElement) {
        waitForElementToBePresent(webElement);
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }


    public Boolean waitForFrameToLoad(String frameId) {

        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
        return true;
    }

    public Boolean waitForFrameToLoad(Integer index) {
        webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
        return true;
    }

    public void waitForPageToLoad() {
        webDriverWait.until(webDriver1 -> ((JavascriptExecutor) webDriver1).executeScript("return document.readyState").equals("complete"));
    }

    public WebElement findFromList(List<WebElement> elementsList, String attribute, String matcher) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elementsList));
        Optional<WebElement> item = elementsList.stream().filter(element -> element.getAttribute(attribute).toLowerCase().contains(matcher.toLowerCase()))
                .findFirst();
        return item.orElseThrow(RuntimeException::new);
    }

    public WebElement findFromList(List<WebElement> elementsList, String matcher) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elementsList));
        Optional<WebElement> item = elementsList.stream().filter(element -> element.getText().toLowerCase().contains(matcher.toLowerCase()))
                .findFirst();
        return item.orElseThrow(RuntimeException::new);
    }

    public void waitForElementToBeInvisible(WebElement webElement) {
        try {
            webDriverWait.until(ExpectedConditions.invisibilityOf(webElement));
        }catch (Exception e) {
            sleep(); //force sleep if dom is stale
        }
    }

    public void switchToDefaultContent() {
        webDriver.switchTo().defaultContent();
    }

    @Override
    public void log(String message) {
        ReportLogger.log(persona, message);
    }

    public void sleep() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setAttribute(WebElement element, String attName, String attValue) {
        jsDriver().executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                element, attName, attValue);
    }

    public void waitForElementsToBeDisplayed(List<WebElement> elements) {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void switchTab() {
        String currentWindowHandle = webDriver.getWindowHandle();
        Optional<String> tab = webDriver.getWindowHandles().stream()
                .filter(handle -> !handle.equals(currentWindowHandle))
                .findFirst();
        tab.ifPresent(s -> webDriver.switchTo().window(s));
    }

    private JavascriptExecutor jsDriver() {
        return ((JavascriptExecutor)webDriver);
    }
}

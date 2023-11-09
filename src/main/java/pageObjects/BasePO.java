package pageObjects;

import core.Constants;
import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePO {

    public BasePO() {

    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void navigateTo(String url) {
        getDriver().get(Constants.WEBDRIVERUNI_BASE_URL + url);
    }

    public WebDriverWait setWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    public void sendKeys(By by, String text) {
        WebDriverWait wait = setWait();
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(text);
    }

    public void sendKeys(WebElement webElement, String text) {
        WebDriverWait wait = setWait();;
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(text);
    }

    public void waitAndClick(By by) {
        WebDriverWait wait = setWait();;
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void waitAndClick(WebElement webElement) {
        WebDriverWait wait = setWait();;
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }
}

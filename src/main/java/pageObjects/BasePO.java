package pageObjects;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static core.Constants.*;

public class BasePO {
    private final WebDriverWait wait = setWait();

    public BasePO() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void navigateTo(String url) {
        getDriver().get(WEBDRIVERUNI_BASE_URL + url);
    }

    public WebDriverWait setWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    public void sendKeys(By by, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(text);
    }

    public void sendKeys(WebElement webElement, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).sendKeys(text);
    }

    public void waitAndClick(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void waitAndClick(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public String getAlertText() {
        wait.until(ExpectedConditions.alertIsPresent());
        return getDriver().switchTo().alert().getText();
    }

    public String getElementText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public String getElementText(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by)).getText();
    }
}

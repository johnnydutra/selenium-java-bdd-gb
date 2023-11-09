package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.BasePO;

import java.time.Duration;

import static core.Constants.WEBDRIVERUNI_BASE_URL;
import static drivers.DriverFactory.getDriver;

public class LoginPortal extends BasePO {
    private WebDriver driver = getDriver();

    @Given("I access the WebDriver University Login Portal page")
    public void i_access_the_web_driver_university_login_portal_page() {
        navigateTo("/Login-Portal/index.html");
    }

    @When("I enter {string} in the username input field")
    public void i_enter_in_the_username_input_field(String username) {
        sendKeys(By.id("text"), username);
    }

    @When("I enter {string} in the password input field")
    public void i_enter_in_the_password_input_field(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("I click the Login button")
    public void i_click_the_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should be presented with an alert with the text {string}")
    public void i_should_be_presented_with_an_alert_with_the_text(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals(alert.getText(), message);
    }

    @When("I enter an username {}")
    public void i_enter_an_username(String username) {
        driver.findElement(By.id("text")).sendKeys(username);
    }

    @When("I enter a password {}")
    public void i_enter_a_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("I should be presented with an alert with the message {}")
    public void i_should_be_presented_with_an_alert_with_the_message(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals(alert.getText(), message);
    }
}

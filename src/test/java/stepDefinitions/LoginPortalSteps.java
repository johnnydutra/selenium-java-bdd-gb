package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pageObjects.BasePO;
import pageObjects.LoginPortalPO;

public class LoginPortalSteps extends BasePO {
    private final LoginPortalPO loginPortal;

    public LoginPortalSteps(LoginPortalPO loginPortal) {
        this.loginPortal = loginPortal;
    }

    @Given("I access the WebDriver University Login Portal page")
    public void i_access_the_web_driver_university_login_portal_page() {
        loginPortal.accessThis();
    }

    @When("I enter {string} in the username input field")
    public void i_enter_in_the_username_input_field(String username) {
        loginPortal.setUsername(username);
    }

    @When("I enter {string} in the password input field")
    public void i_enter_in_the_password_input_field(String password) {
        loginPortal.setPassword(password);
    }

    @When("I click the Login button")
    public void i_click_the_login_button() {
        loginPortal.clickLoginButton();
    }

    @Then("I should be presented with an alert with the text {string}")
    public void i_should_be_presented_with_an_alert_with_the_text(String message) {
        Assert.assertEquals(loginPortal.getAlertText(), message);
    }

    @When("I enter an username {}")
    public void i_enter_an_username(String username) {
        loginPortal.setUsername(username);
    }

    @When("I enter a password {}")
    public void i_enter_a_password(String password) {
        loginPortal.setPassword(password);
    }

    @Then("I should be presented with an alert with the message {}")
    public void i_should_be_presented_with_an_alert_with_the_message(String message) {
        Assert.assertEquals(loginPortal.getAlertText(), message);
    }
}

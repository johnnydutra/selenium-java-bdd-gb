package stepDefinitions;

import core.Support;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.BasePO;

public class ContactUs extends BasePO {
    private WebDriver driver = getDriver();

    @Given("I access the WebDriver University Contact Us page")
    public void i_access_the_web_driver_university_contact_us_page() {
        navigateTo("/Contact-Us/contactus.html");
    }

    @When("I enter an unique first name")
    public void i_enter_an_unique_first_name() {
        sendKeys(By.xpath("//input[@name='first_name']"), "AutoFN" + Support.generateRandomNumber(5));
    }

    @When("I enter an unique last name")
    public void i_enter_an_unique_last_name() {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("AutoLN" + Support.generateRandomNumber(5));
    }

    @When("I enter an unique e-mail address")
    public void i_enter_an_unique_e_mail_address() {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("AutoEM" + Support.generateRandomNumber(5) + "@mail.com");
    }

    @When("I enter an unique comment")
    public void i_enter_an_unique_comment() {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(Support.generateRandomString(20));
    }

    @When("I enter a specific first name {string}")
    public void i_enter_a_specific_first_name(String firstName) {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
    }
    @When("I enter a specific last name {string}")
    public void i_enter_a_specific_last_name(String lastName) {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastName);
    }
    @When("I enter a specific e-mail address {string}")
    public void i_enter_a_specific_e_mail_address(String emailAddress) {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(emailAddress);
    }
    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(comment);
    }

    @When("I click the Submit button")
    public void i_click_the_submit_button() {
        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
    }

    @Then("I should be presented with a successful Contact Us form submission message")
    public void i_should_be_presented_with_a_successful_contact_us_form_submission_message() {
        WebElement contactUsSubmissionMessage = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUsSubmissionMessage.getText(), "Thank You for your Message!");
    }
}

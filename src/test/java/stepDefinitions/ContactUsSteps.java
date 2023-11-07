package stepDefinitions;

import core.Hooks;
import core.Support;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static core.Constants.WEBDRIVERUNI_BASE_URL;

public class ContactUsSteps extends Hooks {
    private WebDriver driver;

    @Given("I access the WebDriver University Contact Us page")
    public void i_access_the_web_driver_university_contact_us_page() {
        driver.get(WEBDRIVERUNI_BASE_URL + "/Contact-Us/contactus.html");
    }

    @When("I enter an unique first name")
    public void i_enter_an_unique_first_name() {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN" + Support.generateRandomNumber(5));
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

    @When("I click the Submit button")
    public void i_click_the_submit_button() {
        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
    }

    @Then("I should be presented with a successful Contact Us form submission message")
    public void i_should_be_presented_with_a_successful_contact_us_form_submission_message() {
        WebElement contactUsSubmissionMessage = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUsSubmissionMessage.getText(), "Thank You for Your Message!");
    }
}

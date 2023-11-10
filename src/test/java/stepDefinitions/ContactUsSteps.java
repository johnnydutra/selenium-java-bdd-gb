package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.BasePO;
import pageObjects.ContactUsPO;

public class ContactUsSteps extends BasePO {
    private final ContactUsPO contactUs;

    public ContactUsSteps(ContactUsPO contactUs) {
        this.contactUs = contactUs;
    }

    @Given("I access the WebDriver University Contact Us page")
    public void i_access_the_web_driver_university_contact_us_page() {
        contactUs.accessThis();
    }

    @When("I enter an unique first name")
    public void i_enter_an_unique_first_name() {
        contactUs.setUniqueFirstName();
    }

    @When("I enter an unique last name")
    public void i_enter_an_unique_last_name() {
        contactUs.setUniqueLastName();
    }

    @When("I enter an unique e-mail address")
    public void i_enter_an_unique_e_mail_address() {
        contactUs.setUniqueEmailAddress();
    }

    @When("I enter an unique comment")
    public void i_enter_an_unique_comment() {
        contactUs.setUniqueComment();
    }

    @When("I enter a specific first name {string}")
    public void i_enter_a_specific_first_name(String firstName) {
        contactUs.setSpecificFirstName(firstName);
    }
    @When("I enter a specific last name {string}")
    public void i_enter_a_specific_last_name(String lastName) {
        contactUs.setSpecificLastName(lastName);
    }
    @When("I enter a specific e-mail address {string}")
    public void i_enter_a_specific_e_mail_address(String emailAddress) {
        contactUs.setSpecificEmailAddress(emailAddress);
    }
    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        contactUs.setSpecificComment(comment);
    }

    @When("I click the Submit button")
    public void i_click_the_submit_button() {
        contactUs.clickSubmitButton();
    }

    @Then("I should be presented with a successful Contact Us form submission message")
    public void i_should_be_presented_with_a_successful_contact_us_form_submission_message() {
        Assert.assertEquals(contactUs.getFormSubmissionMessageText(), "Thank You for your Message!");
    }
}

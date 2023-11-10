package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static core.Support.*;

public class ContactUsPO extends BasePO {

    private @FindBy(how = How.XPATH, using = "//input[@name='first_name']") WebElement firstNameInput;
    private @FindBy(how = How.XPATH, using = "//input[@name='last_name']") WebElement lastNameInput;
    private @FindBy(how = How.XPATH, using = "//input[@name='email']") WebElement emailAddressInput;
    private @FindBy(how = How.XPATH, using = "//textarea[@name='message']") WebElement commentInput;
    private @FindBy(how = How.XPATH, using = "//input[@value='SUBMIT']") WebElement submitButton;
    private @FindBy(how = How.XPATH, using = "//div[@id='contact_reply']/h1") WebElement formSubmissionMessage;

    public ContactUsPO() {
        super();
    }

    public void accessThis() {
        navigateTo("/Contact-Us/contactus.html");
    }

    public void setUniqueFirstName() {
        setSpecificFirstName("AutoFN" + generateRandomNumber(5));
    }

    public void setUniqueLastName() {
        setSpecificLastName("AutoLN" + generateRandomNumber(5));
    }

    public void setUniqueEmailAddress() {
        setSpecificEmailAddress("AutoEM" + generateRandomNumber(5) + "@mail.com");
    }

    public void setUniqueComment() {
        setSpecificComment(generateRandomString(20));
    }

    public void clickSubmitButton() {
        waitAndClick(submitButton);
    }

    public String getFormSubmissionMessageText() {
        return getElementText(formSubmissionMessage);
    }

    public void setSpecificFirstName(String firstName) {
        sendKeys(firstNameInput, firstName);
    }

    public void setSpecificLastName(String lastName) {
        sendKeys(lastNameInput, lastName);
    }

    public void setSpecificEmailAddress(String emailAddress) {
        sendKeys(emailAddressInput, emailAddress);
    }

    public void setSpecificComment(String comment) {
        sendKeys(commentInput, comment);
    }

}

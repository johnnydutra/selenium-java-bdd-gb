package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPortalPO extends BasePO {

    private @FindBy(id = "text") WebElement usernameInput;
    private @FindBy(id = "password") WebElement passwordInput;
    private @FindBy(id = "login-button") WebElement loginButton;

    public LoginPortalPO() {
        super();
    }

    public void accessThis() {
        navigateTo("/Login-Portal/index.html");
    }

    public void setUsername(String username) {
        sendKeys(usernameInput, username);
    }

    public void setPassword(String password) {
        sendKeys(passwordInput, password);
    }

    public void clickLoginButton() {
        waitAndClick(loginButton);
    }
}

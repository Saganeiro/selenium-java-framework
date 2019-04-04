package page.objects;

import managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.WaitForElement;

public class LoginPage {

    @FindBy(xpath = "//div[@class='login_logo']")
    private WebElement loginLogoImage;

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='LOGIN']")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement textWarrningMessage;

    private WebDriver driver;

    public LoginPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

        public void typeUsername (String username){
            WaitForElement.waitUntilElementIsVisible(usernameField);
            usernameField.clear();
            usernameField.sendKeys(username);
        }

        public void typePassword (String password){
            passwordField.clear();
            passwordField.sendKeys(password);
        }

        public void clickLoginButton () {
            WaitForElement.waitUntilElementIsVisible(loginButton);
            loginButton.click();
        }

        public String getWarrningMessage () {
        WaitForElement.waitUntilElementIsVisible(textWarrningMessage);
            String warrningMessage = textWarrningMessage.getText();
            return warrningMessage;
    }
}

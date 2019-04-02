package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


        public void typeUsername (String username){
            usernameField.clear();
            usernameField.sendKeys(username);
        }

        public void typePassword (String password){
            passwordField.clear();
            passwordField.sendKeys(password);
        }

        public void clickLoginButton () {
            loginButton.click();
        }

        public String getWarrningMessage () {

            String warrningMessage = textWarrningMessage.getText();
            return warrningMessage;
    }
}

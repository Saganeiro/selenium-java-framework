package page.objects;

import managers.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.WaitForElement;

public class LoginPage {

    private Logger logger = LogManager.getRootLogger();

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

        public LoginPage typeUsername (String username){
            WaitForElement.waitUntilElementIsVisible(usernameField);
            usernameField.clear();
            usernameField.sendKeys(username);
            logger.info("Typed into User Name Field {}", username);
            return this;
        }

        public LoginPage typePassword (String password){
            passwordField.clear();
            passwordField.sendKeys(password);
            logger.info("Typed into Password Field {}", password);
            return this;
        }

        public FooterPage clickLoginButton () {
            logger.info("Trying to click Login Button");
            WaitForElement.waitUntilElementIsVisible(loginButton);
            loginButton.click();
            logger.info("Clicked on Login Button");
            return new FooterPage();
    }

        public String getWarrningMessage () {
        WaitForElement.waitUntilElementIsVisible(textWarrningMessage);
            String warrningMessage = textWarrningMessage.getText();
            logger.info("Returned warning message was: {}", textWarrningMessage);
            return warrningMessage;
    }
}

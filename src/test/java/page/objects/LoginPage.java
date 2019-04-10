package page.objects;

import generic.assertions.AssertWebElement;
import managers.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.WaitForElement;

public class LoginPage extends BasePage {

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

    public LoginPage typeUsername (String username){
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.clear();
        usernameField.sendKeys(username);
        log().info("Typed into User Name Field {}", username);
        return this;
    }

    public LoginPage typePassword (String password){
        passwordField.clear();
        passwordField.sendKeys(password);
        log().info("Typed into Password Field {}", password);
        return this;
    }

    public FooterPage clickLoginButton () {
        log().info("Trying to click Login Button");
        WaitForElement.waitUntilElementIsVisible(loginButton);
        loginButton.click();
        log().info("Clicked on Login Button");
        return new FooterPage();
    }

    public LoginPage assertThatWarningIsDisplayed(String warningMessage) {
        log().info("Checking if warning message {} is displayed", warningMessage);
        WaitForElement.waitUntilElementIsVisible(textWarrningMessage);
        AssertWebElement.assertThat(textWarrningMessage).isDisplayed().hasText(warningMessage);
        return this;
    }
}

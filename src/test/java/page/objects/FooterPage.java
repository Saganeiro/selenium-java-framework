package page.objects;

import managers.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

import static generic.assertions.AssertWebElement.assertThat;

public class FooterPage extends BasePage {

    @FindBy(xpath = "//footer[@class='footer']")
    private WebElement footerSection;

    public FooterPage assertThatFooterSectionIsDisplayed(){
        log().info("Checking if dog banner is displayed");
        WaitForElement.waitUntilElementIsVisible(footerSection);
        assertThat(footerSection).isDisplayed();
        return this;
    }

}

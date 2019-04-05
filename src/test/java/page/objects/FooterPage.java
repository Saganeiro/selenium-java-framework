package page.objects;

import managers.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//footer[@class='footer']")
    private WebElement footerSection;

    private WebDriver driver;

    public FooterPage(){

        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean isFooterSectionDisplayed(){

        boolean isDisplayed = footerSection.isDisplayed();
        logger.info("Returning status of banner after login: {}", isDisplayed);
        return isDisplayed;

    }

}

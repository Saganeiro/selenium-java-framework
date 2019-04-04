package page.objects;

import managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {

    @FindBy(xpath = "//footer[@class='footer']")
    private WebElement footerSection;

    private WebDriver driver;

    public FooterPage(){

        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean isFooterSectionDisplayed(){

        boolean isDisplayed = footerSection.isDisplayed();
        return isDisplayed;

    }

}

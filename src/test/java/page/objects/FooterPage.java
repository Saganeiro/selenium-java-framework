package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {

    @FindBy(xpath = "//footer[@class='footer']")
    private WebElement footerSection;

    private WebDriver driver;

    public FooterPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isFooterSectionDisplayed(){

        boolean isDisplayed = footerSection.isDisplayed();
        return isDisplayed;

    }

}

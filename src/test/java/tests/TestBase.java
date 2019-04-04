package tests;

import managers.DriverManager;
import managers.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {

    @BeforeMethod
    public void beforeTest() {

        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}

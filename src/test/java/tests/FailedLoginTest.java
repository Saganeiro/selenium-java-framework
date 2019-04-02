package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class FailedLoginTest extends TestBase {

    @Test
    public void loginWithIncorrectCredencials(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("incorrect_password");
        loginPage.clickLoginButton();
        String warrningMessage = loginPage.getWarrningMessage();

        assertEquals(warrningMessage, "Epic sadface: Username and password do not match any user in this service");

    }
}

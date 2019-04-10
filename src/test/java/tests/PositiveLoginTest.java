package tests;

import org.testng.annotations.Test;
import page.objects.FooterPage;
import page.objects.LoginPage;

import static org.testng.Assert.assertTrue;

public class PositiveLoginTest extends TestBase {

    @Test
    public void PositiveLoginTest(){

        LoginPage loginPage = new LoginPage();
        loginPage
            .typeUsername("standard_user")
            .typePassword("secret_sauce")
            .clickLoginButton()
            .assertThatFooterSectionIsDisplayed();
    }
}

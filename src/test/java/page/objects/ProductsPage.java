package page.objects;

import managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class ProductsPage {

    @FindBy(xpath = "//*[contains(@class,'svg-inline--fa fa-shopping-cart fa-w-18 fa-3x')]")
    private WebElement imageShoppingCartEmpty;

    @FindBy(xpath = "fa-layers-counter shopping_cart_badge")
    private WebElement imageShopingCardWithOneItem;

    @FindBy(xpath = "/html//div[@id='inventory_container']/div/div[@id='inventory_container']/div[@class='inventory_list']/div[1]/div[@class='pricebar']/button[.='ADD TO CART']")
    private WebElement buttonAddToCardBackpack;

    private WebDriver driver;

    public ProductsPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void addBackpackToCard() {
        WaitForElement.waitUntilElementIsClickable(buttonAddToCardBackpack);
        buttonAddToCardBackpack.click();
    }



}

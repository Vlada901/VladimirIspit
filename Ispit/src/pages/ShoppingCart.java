package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCart extends BasePage {

    public ShoppingCart (WebDriver driver){
        super (driver);
    }

    By addToCartButtonLightBy = By.id("add-to-cart-sauce-labs-bike-light");
    By addToCartButtonBackpackBy = By.id("add-to-cart-sauce-labs-backpack");
    By shoppingCartBttnBy = By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a");
    By product1By = By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div");
    By product2By = By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div[4]/div[2]/a/div");
    String backpack = "Sauce Labs Backpack";
    String bikeLight = "Sauce Labs Bike Light";


    public ShoppingCart verifyProductsAddedInCart(){
        click(addToCartButtonBackpackBy);
        click(addToCartButtonLightBy);
        click(shoppingCartBttnBy);
        assertTextEquals(readText(product1By), backpack);
        assertTextEquals(readText(product2By), bikeLight);
        return this;
    }


    
}

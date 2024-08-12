package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    By homePageTitleBy = By.className("title");
    By numberOfItemsBy = By.className("inventory_item");
    By addToCartButtonLightBy = By.id("add-to-cart-sauce-labs-bike-light");
    By addToCartButtonBackpackBy = By.id("add-to-cart-sauce-labs-backpack");
    By shoppingCartBttnBy = By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a");
    


    public HomePage verifySuccsesfulLogin(String expectedText){
        String actualText = readText(homePageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }


    public HomePage verifyNumberOfProducts (int expectedNumberOfProducts){
        int actualNumberOfProducts = countItems(numberOfItemsBy);
        assertEquals(expectedNumberOfProducts, actualNumberOfProducts);
        return this;
    }

    public HomePage addProductsToCart(){
        click(addToCartButtonBackpackBy);
        click(addToCartButtonLightBy);
        click(shoppingCartBttnBy);
        return this;
    }
    
}

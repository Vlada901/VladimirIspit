package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    By checkoutButtonBy = By.xpath("//*[@id=\"checkout\"]");
    By firstNameFieldBy = By.xpath("//*[@id=\"first-name\"]");
    By lastNameFieldBy = By.xpath("//*[@id=\"last-name\"]");
    By zipCodeFieldBy = By.xpath("//*[@id=\"postal-code\"]");
    By continueButtonBy = By.xpath("//*[@id=\"continue\"]");
    By totalPriceFieldBy = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[8]");
    By finishButtonBy = By.xpath("//*[@id=\"finish\"]");
    By completeHeaderBy = By.xpath("/html/body/div/div/div/div[2]/h2");
    By itemsPriceFieldBy = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[6]");
    By taxPriceFieldBy =  By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[7]");



    public CheckoutPage checkout(String firstName, String lastName, String zipCode){
        click(checkoutButtonBy);
        writeText(firstNameFieldBy, firstName);
        writeText(lastNameFieldBy, lastName);
        writeText(zipCodeFieldBy, zipCode);
        click(continueButtonBy);
        return this;
    }

    public CheckoutPage verifyTotalPrice(){
        Double price1 = Double.parseDouble(readText(itemsPriceFieldBy).substring(13));
        Double price2 = Double.parseDouble(readText(taxPriceFieldBy).substring(6));
        Double price3 = price1 + price2;
        Double price4 = Double.parseDouble(readText(totalPriceFieldBy).substring(8));
        assertDoubleEquals(price3, price4);
        return this;

    }

    public CheckoutPage verifySuccsessfulShopping(String expectedMessage){
        click(finishButtonBy);
        String actualMessage = readText(completeHeaderBy);
        assertTextEquals(expectedMessage, actualMessage);
        return this;
    }

        
    
}

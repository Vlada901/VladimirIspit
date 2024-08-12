package tests;

import org.junit.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ShoppingCart;

public class ShoppingTests extends BaseTest {

    public LoginPage loginPage;
    public HomePage homePage;
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String homePageTitle = "Products";
    int expectedNumberOfProducts = 6;
    String firstName = "Vlada";
    String lastName = "Nedeljkovic";
    String zipCode = "22405";
    String expectedMessage = "Thank you for your order!";



@Test
    public void verifyNumberOfProducts(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccsesfulLogin(homePageTitle);
        homePage.verifyNumberOfProducts(expectedNumberOfProducts);

        try{
            Thread.sleep(4000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

@Test
    public void verifySuccsessfulAddToCart(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ShoppingCart shoppingCart = new ShoppingCart(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccsesfulLogin(homePageTitle);
        shoppingCart.verifyProductsAddedInCart();

        try{
            Thread.sleep(4000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

@Test
    public void verifyFinalPrice(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccsesfulLogin(homePageTitle);
        homePage.addProductsToCart();
        checkoutPage.checkout(firstName, lastName, zipCode);
        checkoutPage.verifyTotalPrice();


        try{
            Thread.sleep(4000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }

@Test
    public void verifyShoppingConfirmation(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccsesfulLogin(homePageTitle);
        homePage.addProductsToCart();
        checkoutPage.checkout(firstName, lastName, zipCode);
        checkoutPage.verifySuccsessfulShopping(expectedMessage);

        try{
            Thread.sleep(4000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
    
}


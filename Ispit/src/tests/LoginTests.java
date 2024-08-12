package tests;

import org.junit.Test;
import org.openqa.selenium.By;

import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    public LoginPage loginPage;
    public HomePage homePage;
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String homePageTitle = "Products";
    String suspendedUser = "locked_out_user";
    String suspendedUserError = "Epic sadface: Sorry, this user has been locked out.";
    String noUsername = "";
    String noUsernameError = "Epic sadface: Username is required";
    String noPassword = "";
    String noPasswordError = "Epic sadface: Password is required";
    String invalidUserame = "house";
    String invalidCredentialsError = "Epic sadface: Username and password do not match any user in this service";
    By menuButtonBy = By.id("react-burger-menu-btn");
    By logoutBttnBy = By.id("logout_sidebar_link");




@Test
public void verifySuccesfulLogin(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccsesfulLogin(homePageTitle);

    try{
        Thread.sleep(4000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
    
   }

@Test 
public void verifyUnsuccsessfulNoPasswordLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, noPassword);
    loginPage.verifyUnsuccsessfulLogin(noPasswordError);
    try{
        Thread.sleep(4000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }

}

@Test
public void verifyUnsuccsessfulNoUsernameLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(noUsername, password);
    loginPage.verifyUnsuccsessfulLogin(noUsernameError);
    try{
        Thread.sleep(4000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifyUnsuccsessfulInvalidUsernameLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(invalidUserame, password);
    loginPage.verifyUnsuccsessfulLogin(invalidCredentialsError);
    try{
        Thread.sleep(4000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifyLogout(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccsesfulLogin(homePageTitle);
    loginPage.verifyLogout();
    try{
        Thread.sleep(4000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
    
}

}

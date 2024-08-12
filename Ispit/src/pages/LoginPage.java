package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

        String baseURL = "https://www.saucedemo.com/";
        By usernameFieldBy = By.id("user-name");
        By passwordFieldBy = By.id("password");
        By loginButtonBy = By.id("login-button");
        By errorContainerBy = By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]");
        By menuButtonBy = By.id("react-burger-menu-btn");
        By logoutBttnBy = By.id("logout_sidebar_link");



        public LoginPage basePage(){
            driver.get(baseURL);
            return this;
        }  
        
        public LoginPage login(String username, String password){
            writeText(usernameFieldBy, username);
            writeText(passwordFieldBy, password);
            click(loginButtonBy);
            return this;
        }

        public LoginPage verifyUnsuccsessfulLogin(String expectedText){
            String actualText = readText(errorContainerBy);
            assertTextEquals(expectedText, actualText);
            return this;
        }

        public LoginPage verifyLogout(){
            click(menuButtonBy);
            click(logoutBttnBy);
            waitVisibility(usernameFieldBy);
            waitVisibility(passwordFieldBy);
            waitVisibility(loginButtonBy);
            return this;
        }
}    
